package rqcode.stigs.win10_new.RegistryEdit;

import rqcode.stigs.win10_new.patterns.STIGPattern;
import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

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