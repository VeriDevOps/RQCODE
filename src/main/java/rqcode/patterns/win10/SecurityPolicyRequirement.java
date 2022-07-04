package rqcode.patterns.win10;

import rqcode.concepts.CheckableEnforceableRequirement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class SecurityPolicyRequirement extends CheckableEnforceableRequirement {
    public static final String CHECK_TEXT_TEMPLATE =
            "Verify the effective setting in Local Group Policy Editor.\n" +
                    "Run \"gpedit.msc\".\n" +
                    "\n" +
                    "Navigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Account Policies >> ";

    public static final String FIX_TEXT_TEMPLATE =
            "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Account Policies >> ";

    private static final Map<Integer, String> COMMAND_TEMPLATE_MAP;

    static {
        COMMAND_TEMPLATE_MAP = new HashMap<>();
        COMMAND_TEMPLATE_MAP.put(1, "$SecPool = Parse-SecPol -CfgFile C:\\Test.cfg\n" +
                "    $valor = $SecPool.'System Access'.%s\n" +
                "    $valor = $valor -as [int]\n" +
                "    if %s{\n" +
                "        $SecPool.'System Access'.%s = %s\n" +
                "        Set-SecPol -Object $SecPool -CfgFile C:\\Test.cfg\n" +
                "    }\n" +
                "    Remove-Item C:\\Test.cfg -Force\n");
        COMMAND_TEMPLATE_MAP.put(2, "secedit /export /cfg c:\\temp\\secpol.cfg\n" +
                "    (Get-Content C:\\temp\\secpol.cfg) -Replace \"PasswordComplexity = 0\",\"PasswordComplexity = 1\" | Out-File C:\\temp\\secpol.cfg\n" +
                "    secedit /configure /db c:\\windows\\security\\local.sdb /cfg c:\\temp\\secpol.cfg /areas SECURITYPOLICY\n" +
                "    Remove-Item C:\\temp\\secpol.cfg -Force -confirm:$false\n");
    }

    private static final Map<String , String> CONDITION_TEMPLATE_MAP;

    static {
        CONDITION_TEMPLATE_MAP = new HashMap<>();
        CONDITION_TEMPLATE_MAP.put("3" , "(($value -gt 3) -or ($value -eq 0))");
        CONDITION_TEMPLATE_MAP.put("15", "($valor -lt 15)");
        CONDITION_TEMPLATE_MAP.put("14", "($valor -lt 14)");
    }

    protected abstract String getCategory();
    protected abstract String getValueType();

    protected abstract Integer getCommandKey();

    protected abstract String getInclusionSetting();
    protected abstract String getOption();

    protected abstract String getCheckTextAdditional();
    protected abstract String getFixTextAdditional();

    @Override
    public CheckStatus check() {
        Integer commandKey = getCommandKey();
        String valueType = getValueType();

        String option = getOption();
        String inclusionSetting = getInclusionSetting();

        List<Map<String, String>> secPolPolicy;
        try {
            secPolPolicy = SecurityPolicyRequirement.SecPol.get(commandKey, valueType, inclusionSetting);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }

        if (secPolPolicy.isEmpty())
            return CheckStatus.FAIL;

        for (Map<String, String> entry : secPolPolicy) {
            if (entry.get("Option").equals(option)
                    && entry.get("Inclusion Setting").contains(inclusionSetting))
                return CheckStatus.PASS;
        }
        return CheckStatus.FAIL;
    }

    @Override
    public EnforcementStatus enforce() {
        Integer commandKey = getCommandKey();
        String valueType = getValueType();
        String inclusionSetting = getInclusionSetting();

        try {
            SecurityPolicyRequirement.SecPol.set(commandKey, valueType, inclusionSetting);
        } catch (Exception e) {
            e.printStackTrace();
            return EnforcementStatus.FAILURE;
        }
        return EnforcementStatus.SUCCESS;
    }


    @Override
    public String checkText() {
        return CHECK_TEXT_TEMPLATE + getCategory() + getCheckTextAdditional();
    }

    @Override
    public String fixText() {
        return FIX_TEXT_TEMPLATE + getCategory() + " >> " + getOption() + " to " + getInclusionSetting() + getFixTextAdditional();
    }

    static class SecPol {

        private static String prepareCommand(Integer commandKey, String valueType, String setting) {
            String command = COMMAND_TEMPLATE_MAP.get(commandKey);
            if (commandKey == 1) {
                String condition = CONDITION_TEMPLATE_MAP.get(setting);
                return String.format(command, valueType, condition, valueType, setting);
            } else return command;
        }

        public static List<Map<String, String>> get(Integer commandKey, String valueType, String setting) throws Exception {
            String secPolCommand = prepareCommand(commandKey, valueType, setting);

            Process secPolProcess = Runtime.getRuntime().exec(secPolCommand);
            BufferedReader secPolOutputReader = new BufferedReader(new InputStreamReader(secPolProcess.getInputStream()));

            List<String> secPolEdit = new LinkedList<>();
            for (String inputLine = secPolOutputReader.readLine(); inputLine != null; inputLine = secPolOutputReader
                    .readLine()) {
                if (!inputLine.trim().isEmpty())
                    secPolEdit.add(inputLine);
            }
            int secPolExitStatus = secPolProcess.waitFor();
            if (secPolExitStatus != 0)
                throw new Exception(String.format("command returned %d", secPolExitStatus));

            String[] secPolHeaders = secPolEdit.get(0).split(",", -1);
            List<Map<String, String>> ret = new LinkedList<>();
            for (String line : secPolEdit.subList(1, secPolEdit.size())) {
                String[] secPolLineFields = line.split(",", -1);
                assert secPolHeaders.length == secPolLineFields.length;

                Map<String, String> secPolEntry = new HashMap<>();
                for (int i = 0; i < secPolHeaders.length; ++i)
                    secPolEntry.put(secPolHeaders[i], secPolLineFields[i]);
                ret.add(secPolEntry);
            }
            return ret;
        }

        public static void set(Integer commandKey, String valueType, String setting) throws IOException, InterruptedException {
            String secPolCommand = prepareCommand(commandKey, valueType, setting);
            Process secPolProcess = Runtime.getRuntime().exec(secPolCommand);
            secPolProcess.waitFor();
        }
    }
}
