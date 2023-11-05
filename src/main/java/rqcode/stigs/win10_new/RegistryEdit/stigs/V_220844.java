package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220844 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\PhishingFilter\\",
                            "attr", "EnabledV9",
                            "result_value", "0x00000001 (1)"
                    ),
                    Map.of(
                            "path", "\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\PhishingFilter\\",
                            "attr", "EnabledV9",
                            "result_value", "0x00000001 (1)"));


    public V_220844() {
        pattern = this.policyScriptPattern;
    }


}
