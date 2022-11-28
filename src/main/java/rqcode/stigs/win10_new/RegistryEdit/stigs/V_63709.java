package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.patterns.win10_new.STIGScriptPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

public class V_63709 extends RegistryEditPattern {
    private final RegistryEditScriptPattern pattern =
            new RegistryEditScriptPattern(RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN, 
            "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Main", 
            "FormSuggest Passwords", 
            "DWORD", 
            "no");


    @Override
    public STIGScriptPattern pattern() {
        return pattern;
    }
}