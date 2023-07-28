package rqcode.stigs.win10_new.RegistryEdit;

import rqcode.stigs.win10_new.patterns.STIGPattern;
import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

public class RegistryEditPattern implements STIGPattern {

    @Override
    public CheckStatus check() {
        String settingName = pattern().getSettingName();
        String settingValue = pattern().getSettingValue();
        String settingValueType = pattern().getSettingValueType();

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
        return null;
    }

    @Override
    public STIGScriptPattern pattern() {
        return null;
    }

    @Override
    public boolean checkProcess(String script, String settingName, String settingValue) throws Exception {
        return true;
    }
}