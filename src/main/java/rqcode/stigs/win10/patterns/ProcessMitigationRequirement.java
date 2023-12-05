package rqcode.stigs.win10.patterns;

import rqcode.stigs.STIG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class ProcessMitigationRequirement extends STIG {
    public static final String CHECK_TEXT_TEMPLATE = "This is NA prior to v1709 of Windows 10.\n" +
            "\n" +
            "This is applicable to unclassified systems, for other systems this is NA.";

    public static final String FIX_TEXT_TEMPLATE = "The XML file is applied with the group policy setting Computer Configuration >> Administrative Settings >> Windows Components >> Windows Defender Exploit Guard >> Exploit Protection >> \"%s\" configured to \"%s\" with file name and location defined under \"Options:\". It is recommended the file be in a read-only network location.";


    private static final Map<Integer, String> COMMAND_TEMPLATE_MAP;

    static {
        COMMAND_TEMPLATE_MAP = new HashMap<>();
        COMMAND_TEMPLATE_MAP.put(1, "$status =Get-ProcessMitigation -System\n" +
                "        $value = $status.%s.%s\n" +
                " \n" +
                "        if ($value -eq \"%s\"){\n" +
                "                Set-ProcessMitigation -System -Enable %s\n" +
                "        }\n" +
                "    }\n" +
                "    Remove-Item C:\\Test.cfg -Force\n");
        COMMAND_TEMPLATE_MAP.put(2, "    set-ProcessMitigation -Name Acrobat.exe -enable Dep\n" +
                "    set-ProcessMitigation -Name Acrobat.exe -enable BottomUp\n" +
                "    set-ProcessMitigation -Name Acrobat.exe -enable ForceRelocateImages\n" +
                "    set-ProcessMitigation -Name Acrobat.exe -enable EnableExportAddressFilterPlus\n" +
                "    set-ProcessMitigation -Name Acrobat.exe -enable EnableExportAddressFilter\n" +
                "    set-ProcessMitigation -Name Acrobat.exe -enable EnableImportAddressFilter\n" +
                "    set-ProcessMitigation -Name Acrobat.exe -enable EnableRopSimExec\n" +
                "    set-ProcessMitigation -Name Acrobat.exe -enable EnableRopCallerCheck\n" +
                "    set-ProcessMitigation -Name Acrobat.exe -enable EnableRopStackPivot\n");
    }

    protected abstract String getStatusType();

    protected abstract String getStatusName();

    protected abstract String getCondition();

    protected abstract Integer getCommandKey();

    protected abstract String getInclusionSetting();

    protected abstract String getOption();

    protected abstract String getCheckTextAdditional();

    protected abstract String getFixTextAdditional();

    @Override
    public CheckStatus check() {
        Integer commandKey = getCommandKey();
        String statusType = getStatusType();
        String statusName = getStatusName();
        String condition = getCondition();

        String option = getOption();
        String inclusionSetting = getInclusionSetting();

        List<Map<String, String>> procMitPolicy;
        try {
            procMitPolicy = ProcessMitigationRequirement.ProcMit.get(commandKey, statusType, statusName, condition);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }

        if (procMitPolicy.isEmpty())
            return CheckStatus.FAIL;

        for (Map<String, String> entry : procMitPolicy) {
            if (entry.get("Option").equals(option)
                    && entry.get("Inclusion Setting").contains(inclusionSetting))
                return CheckStatus.PASS;
        }
        return CheckStatus.FAIL;
    }

    @Override
    public EnforcementStatus enforce() {
        Integer commandKey = getCommandKey();
        String statusType = getStatusType();
        String statusName = getStatusName();
        String condition = getCondition();

        try {
            ProcessMitigationRequirement.ProcMit.set(commandKey, statusType, statusName, condition);
        } catch (Exception e) {
            e.printStackTrace();
            return EnforcementStatus.FAILURE;
        }
        return EnforcementStatus.SUCCESS;
    }


    @Override
    public String checktext() {
        return CHECK_TEXT_TEMPLATE + getCheckTextAdditional();
    }

    @Override
    public String fixtext() {
        return getFixTextAdditional() + String.format(FIX_TEXT_TEMPLATE, getOption(), getInclusionSetting());
    }

    static class ProcMit {

        private static String prepareCommand(Integer commandKey, String statusType, String statusName, String condition) {
            String command = COMMAND_TEMPLATE_MAP.get(commandKey);
            if (commandKey == 1) {
                String commandStatus = getCommandStatus(statusType, statusName);
                return String.format(command, statusType, statusName, condition, commandStatus);
            } else return command;
        }

        private static String getCommandStatus(String statusType, String statusName) {
            if (statusType.equals("DEP"))
                return statusType;
            else if (statusType.equals("ASLR"))
                return statusName + statusType;
            else return statusName;
        }

        public static List<Map<String, String>> get(Integer commandKey, String statusType, String statusName, String condition) throws Exception {
            String procMitCommand = prepareCommand(commandKey, statusType, statusName, condition);

            Process procMitProcess = Runtime.getRuntime().exec(procMitCommand);
            BufferedReader procMitOutputReader = new BufferedReader(new InputStreamReader(procMitProcess.getInputStream()));

            List<String> procMitEdit = new LinkedList<>();
            for (String inputLine = procMitOutputReader.readLine(); inputLine != null; inputLine = procMitOutputReader
                    .readLine()) {
                if (!inputLine.trim().isEmpty())
                    procMitEdit.add(inputLine);
            }
            int procMitExitStatus = procMitProcess.waitFor();
            if (procMitExitStatus != 0)
                throw new Exception(String.format("command returned %d", procMitExitStatus));

            String[] procMitHeaders = procMitEdit.get(0).split(",", -1);
            List<Map<String, String>> ret = new LinkedList<>();
            for (String line : procMitEdit.subList(1, procMitEdit.size())) {
                String[] procMitLineFields = line.split(",", -1);
                assert procMitHeaders.length == procMitLineFields.length;

                Map<String, String> procMitEntry = new HashMap<>();
                for (int i = 0; i < procMitHeaders.length; ++i)
                    procMitEntry.put(procMitHeaders[i], procMitLineFields[i]);
                ret.add(procMitEntry);
            }
            return ret;
        }

        public static void set(Integer commandKey, String statusType, String statusName, String condition) throws IOException, InterruptedException {
            String procMitCommand = prepareCommand(commandKey, statusType, statusName, condition);
            Process procMitProcess = Runtime.getRuntime().exec(procMitCommand);
            procMitProcess.waitFor();
        }
    }
}
