package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_63709 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "", "",
                            "", ""
                    ),
                    Map.of(
                            "registryPath", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Main",
                            "name", "FormSuggest Passwords",
                            "type", "DWORD",
                            "value", "no"));

    public V_63709() {
        pattern = this.policyScriptPattern;
    }
}