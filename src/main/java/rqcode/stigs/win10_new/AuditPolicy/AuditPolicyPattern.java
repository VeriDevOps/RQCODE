package rqcode.stigs.win10_new.AuditPolicy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import rqcode.stigs.win10_new.patterns.STIGPattern;

public abstract class AuditPolicyPattern implements STIGPattern {

    @Override
    public CheckStatus check() {
        String settingName = pattern().getSettingName();
        String settingValue = pattern().getSettingValue();

        String script = pattern().prepareCheckScript();

        boolean auditPolicyCheck;
        try {
            auditPolicyCheck = checkProcess(script, settingName, settingValue);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }

        if (auditPolicyCheck)
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
        Process auditPol = Runtime.getRuntime().exec(script);
        BufferedReader auditPolOutputReader = new BufferedReader(new InputStreamReader(auditPol.getInputStream()));

        StringBuilder processOutput = new StringBuilder();
        String inputLine;

        while ((inputLine = auditPolOutputReader.readLine()) != null) {
            processOutput.append(inputLine + System.lineSeparator());
        }

        String result = processOutput.toString().toLowerCase();
        boolean flag = settingValue.equals("enable");

        return result.contains(settingName) && flag;
    }
}