package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220814 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Group Policy\\{35378EAC-683F-11D2-A89A-00C04FBBCFA2",
                            "attr", "NoGPOListChanges",
                            "result_value", "0",
                            "id", "V_220814"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Group Policy\\{35378EAC-683F-11D2-A89A-00C04FBBCFA2",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Group Policy",
                            "attr", "NoGPOListChanges",
                            "result_value", "0"
                            
                        ),
                    Map.of(
                            "description", "The Windows Explorer Preview pane must be disabled for Windows 10."
                        )
                );


    public V_220814() {
        pattern = this.policyScriptPattern;
    }


}
