package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220917 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
                            "attr", "DisablePasswordChange",
                            "result_value", "0",
                            "id", "V_220917"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon",
                            "attr", "DisablePasswordChange",
                            "result_value", "0"
                            
                        ),
                    Map.of(
                            "description", "Local accounts with blank passwords must be restricted to prevent access from the network."
                        )
                );


    public V_220917() {
        pattern = this.policyScriptPattern;
    }


}
