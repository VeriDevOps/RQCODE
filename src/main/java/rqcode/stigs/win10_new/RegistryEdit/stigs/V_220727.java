package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220727 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\kernel",
                            "attr", "DisableExceptionChainValidation",
                            "result_value", "0",
                            "id", "V_220727"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\kernel",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager",
                            "attr", "DisableExceptionChainValidation",
                            "result_value", "0"
                            
                        ),
                    Map.of(
                            "description", "Local users on domain-joined computers must not be enumerated."
                        )
                );


    public V_220727() {
        pattern = this.policyScriptPattern;
    }


}
