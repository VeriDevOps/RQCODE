package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220948 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
                            "attr", "EnableInstallerDetection",
                            "result_value", "1",
                            "id", "V_220948"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
                            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
                            "attr", "EnableInstallerDetection",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "User Account Control must run all administrators in Admin Approval Mode, enabling UAC."
                        )
                );


    public V_220948() {
        pattern = this.policyScriptPattern;
    }


}
