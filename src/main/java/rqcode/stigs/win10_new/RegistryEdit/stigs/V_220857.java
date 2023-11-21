package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220857 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer",
                            "attr", "AlwaysInstallElevated",
                            "result_value", "0",
                            "id", "V_220857"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
                            "attr", "AlwaysInstallElevated",
                            "result_value", "0"
                            
                        ),
                    Map.of(
                            "description", "Structured Exception Handling Overwrite Protection (SEHOP) must be enabled."
                        )
                );


    public V_220857() {
        pattern = this.policyScriptPattern;
    }


}
