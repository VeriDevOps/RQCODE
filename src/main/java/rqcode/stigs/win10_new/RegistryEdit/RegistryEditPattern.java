package rqcode.stigs.win10_new.RegistryEdit;

import rqcode.stigs.win10_new.patterns.STIGPattern;
import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class RegistryEditPattern implements STIGPattern {

    @Override
    public CheckStatus check() {
        String settingName = pattern().getSettingName();
        String settingValue = pattern().getSettingValue();

        String script = pattern().prepareCheckScript();

        boolean registryEditCheck;
        try {
            registryEditCheck = checkProcess(script, settingName, settingValue);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }

        if (registryEditCheck)
            return CheckStatus.PASS;
        else
            return CheckStatus.FAIL;
    }

    @Override
    public EnforcementStatus enforce() {
        String script = pattern().prepareEnforceScript();

        try {
            Process process = Runtime.getRuntime().exec(script);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return EnforcementStatus.FAILURE;
        }
        return EnforcementStatus.SUCCESS;
    }

    @Override
    public boolean checkProcess(String script, String settingName, String settingValue) throws Exception {
        Process regEdit = Runtime.getRuntime().exec(script);
        BufferedReader regEditOutputReader = new BufferedReader(new InputStreamReader(regEdit.getInputStream()));

        StringBuilder processOutput = new StringBuilder();
        String inputLine;

        while ((inputLine = regEditOutputReader.readLine()) != null) {
            processOutput.append(inputLine + System.lineSeparator());
        }

        String result = processOutput.toString().toLowerCase();
        boolean flag = settingValue.equals("enable");

        return result.contains(settingName) && flag;
    }
}