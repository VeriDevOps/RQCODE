package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220830 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Biometrics\\FacialFeatures",
                            "attr", "EnhancedAntiSpoofing",
                            "result_value", "0x00000001 (1)",
                            "id", "V_220830"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Biometrics\\FacialFeatures",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Biometrics",
                            "attr", "EnhancedAntiSpoofing",
                            "result_value", "0x00000001 (1)"));


    public V_220830() {
        pattern = this.policyScriptPattern;
    }


}
