package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220824 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Rpc",
                            "attr", "RestrictRemoteClients",
                            "result_value", "1",
                            "id", "V_220824"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Rpc",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT",
                            "attr", "RestrictRemoteClients",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "Kerberos encryption types must be configured to prevent the use of DES and RC4 encryption suites."
                        )
                );


    public V_220824() {
        pattern = this.policyScriptPattern;
    }


}
