package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220800 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders\\Wdigest",
                            "attr", "UseLogonCredential",
                            "result_value", "0",
                            "id", "V_220800"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders\\Wdigest",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders",
                            "attr", "UseLogonCredential",
                            "result_value", "0"
                            
                        ),
                    Map.of(
                            "description", "Local drives must be prevented from sharing with Remote Desktop Session Hosts."
                        )
                );


    public V_220800() {
        pattern = this.policyScriptPattern;
    }


}
