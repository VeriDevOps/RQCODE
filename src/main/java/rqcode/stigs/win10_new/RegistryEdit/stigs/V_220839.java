package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220839 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer",
                            "attr", "PreXPSP2ShellProtocolBehavior",
                            "result_value", "0",
                            "id", "V_220839"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer",
                            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
                            "attr", "PreXPSP2ShellProtocolBehavior",
                            "result_value", "0"
                            
                        ),
                    Map.of(
                            "description", "Unauthenticated RPC clients must be restricted from connecting to the RPC server."
                        )
                );


    public V_220839() {
        pattern = this.policyScriptPattern;
    }


}
