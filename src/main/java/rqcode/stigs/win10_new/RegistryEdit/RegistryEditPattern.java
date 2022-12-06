package rqcode.stigs.win10_new.RegistryEdit;

import rqcode.patterns.win10_new.STIGPattern;
import rqcode.patterns.win10_new.STIGScriptPattern;

public class RegistryEditPattern implements STIGPattern {

    @Override
    public CheckStatus check() {
        return null;
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