package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220902 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Kernel DMA Protectio",
                            "attr", "DeviceEnumerationPolicy",
                            "result_value", "0"
                    ),
                    Map.of(
                            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Kernel DMA Protectio",
                            "path_short", "HKLM:\\Software\\Policies\\Microsoft\\Windows",
                            "attr", "DeviceEnumerationPolicy",
                            "result_value", "0"));


    public V_220902() {
        pattern = this.policyScriptPattern;
    }


}
