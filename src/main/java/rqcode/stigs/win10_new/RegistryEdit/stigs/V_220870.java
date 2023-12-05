package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220870 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Syste",
                            "attr", "AllowDomainPINLogon",
                            "result_value", "0",
                            "id", "V_220870"
                    ),
                    Map.of(
                            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Syste",
                            "path_short", "HKLM:\\Software\\Policies\\Microsoft\\Windows",
                            "attr", "AllowDomainPINLogon",
                            "result_value", "0"
                            
                        ),
                    Map.of(
                            "description", "Windows 10 must be configured to require a minimum pin length of six characters or greater."
                        )
                );


    public V_220870() {
        pattern = this.policyScriptPattern;
    }


}
