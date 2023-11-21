package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220849 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
                            "attr", "fDisableCdm",
                            "result_value", "1",
                            "id", "V_220849"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT",
                            "attr", "fDisableCdm",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "The system must be configured to ignore NetBIOS attr release requests except from WINS servers."
                        )
                );


    public V_220849() {
        pattern = this.policyScriptPattern;
    }


}
