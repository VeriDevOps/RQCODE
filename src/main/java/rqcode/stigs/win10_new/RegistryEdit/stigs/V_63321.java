package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;
import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

public class V_63321 extends RegistryEditPattern {
    private final RegistryEditScriptPattern pattern =
            new RegistryEditScriptPattern(RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN,
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK,
                    "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Main",
                    "FormSuggest Passwords",
                    "DWORD",
                    "0");


    @Override
    public STIGScriptPattern pattern() {
        return pattern;
    }
}