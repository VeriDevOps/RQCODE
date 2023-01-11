package rqcode.stigs.win10.patterns;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import rqcode.concepts.CheckableEnforceableRequirement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class RegistryEditRequirement extends CheckableEnforceableRequirement {
    private static final String REGISTRY_HIVE = "HKEY_LOCAL_MACHINE";
    private static final String REGISTRY_ROOT = "HKLM:";
    private static final String COMMAND_BODY =
            "if (!(Test-Path $registryPath)){\n" +
                    "\tNew-Item -Path $registryPath -Force\n" +
                    "\t\n" +
                    "\tNew-ItemProperty -Path $registryPath -Name $name -PropertyType $type -Value $value -Force\n" +
                    "\n" +
                    "}\n" +
                    "\n" +
                    "else{\n" +
                    "\n" +
                    "\tNew-ItemProperty -Path $registryPath -Name $name -PropertyType $type -Value $value -Force\n" +
                    "\t\n" +
                    "}";

    private static final String CHECK_TEXT_TEMPLATE =
            "If the following registry value does not exist or is not configured as specified, this is a finding:\n" +
                    "Registry Hive: %S\n" +
                    "Registry Path: %s\n" +
                    "\n" +
                    "Value Name: %s\n" +
                    "\n" +
                    "Value Type: %s\n" +
                    "Value: %s";

    protected abstract String getRegistryPath();
    protected abstract String getValueName();
    protected abstract String getValueType();
    protected abstract String getValue();

    protected abstract String getInclusionSetting();
    protected abstract String getOption();

    @Override
    public CheckStatus check() {
        String registryPath = getRegistryPath();
        String valueName = getValueName();
        String value = getValue();

        String option = getOption();
        String inclusionSetting = getInclusionSetting();

        List<Map<String, String>> regEditPolicy;
        try {
            regEditPolicy = RegistryEditRequirement.RegEdit.get(registryPath, valueName, value);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }

        if (regEditPolicy.isEmpty())
            return CheckStatus.FAIL;

        for (Map<String, String> entry : regEditPolicy) {
            if (entry.get("Option").equals(option)
                    && entry.get("Inclusion Setting").contains(inclusionSetting))
                return CheckStatus.PASS;
        }
        return CheckStatus.FAIL;
    }

    @Override
    public EnforcementStatus enforce() {
        String registryPath = getRegistryPath();
        String valueName = getValueName();
        String value = getValue();

        try {
            RegistryEditRequirement.RegEdit.set(registryPath, valueName, value);
        } catch (Exception e) {
            e.printStackTrace();
            return EnforcementStatus.FAILURE;
        }
        return EnforcementStatus.SUCCESS;
    }

    public String getCheckTextBody(){
        return String.format(CHECK_TEXT_TEMPLATE, REGISTRY_HIVE, getRegistryPath(), getValueName(), getValueType(), getValue());
    }

    static class RegEdit {

        private static String getCommandParameters(String registryPath, String name, String value) {
            return String.format("$registryPath = %s", sanitizeArgument(REGISTRY_ROOT + registryPath))
                    + String.format("\n$name = %s", sanitizeArgument(name))
                    + "\n$type = \"DWORD\""
                    + String.format("\n$value = %s\n", sanitizeArgument(value));
        }

        @objid("3b9d83f6-1bcc-4356-acae-5461ed28692c")
        private static String sanitizeArgument(String arg) {
            if (arg != null && arg.contains(" "))
                arg = String.format("\"%s\"", arg);
            return arg;
        }

        public static List<Map<String, String>> get(String registryPath, String name, String value) throws Exception {
            String regEditCommand = prepareCommand(registryPath, name, value);

            Process regEditProcess = Runtime.getRuntime().exec(regEditCommand);
            BufferedReader regEditOutputReader = new BufferedReader(new InputStreamReader(regEditProcess.getInputStream()));

            List<String> rawRegEdit = new LinkedList<>();
            for (String inputLine = regEditOutputReader.readLine(); inputLine != null; inputLine = regEditOutputReader
                    .readLine()) {
                if (!inputLine.trim().isEmpty())
                    rawRegEdit.add(inputLine);
            }
            int regEditExitStatus = regEditProcess.waitFor();
            if (regEditExitStatus != 0)
                throw new Exception(String.format("command returned %d", regEditExitStatus));

            String[] regEditHeaders = rawRegEdit.get(0).split(",", -1);
            List<Map<String, String>> ret = new LinkedList<>();
            for (String line : rawRegEdit.subList(1, rawRegEdit.size())) {
                String[] regEditLineFields = line.split(",", -1);
                assert regEditHeaders.length == regEditLineFields.length;

                Map<String, String> regEditEntry = new HashMap<>();
                for (int i = 0; i < regEditHeaders.length; ++i)
                    regEditEntry.put(regEditHeaders[i], regEditLineFields[i]);
                ret.add(regEditEntry);
            }
            return ret;
        }

        public static void set(String registryPath, String name, String value) throws IOException, InterruptedException {
            String regEditCommand = prepareCommand(registryPath, name, value);
            Process regEditProcess = Runtime.getRuntime().exec(regEditCommand);
            regEditProcess.waitFor();
        }

        private static String prepareCommand(String registryPath, String name, String value) {
            String regEditParameters = getCommandParameters(registryPath, name, value);
            return regEditParameters + COMMAND_BODY;
        }

    }
}
