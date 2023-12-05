package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220860 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell\\ScriptBlockLogging",
                            "attr", "EnableScriptBlockLogging",
                            "result_value", "1",
                            "id", "V_220860"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell\\ScriptBlockLogging",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell",
                            "attr", "EnableScriptBlockLogging",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "User Account Control must virtualize file and registry write failures to per-user locations."
                        )
                );


    public V_220860() {
        pattern = this.policyScriptPattern;
    }


}
