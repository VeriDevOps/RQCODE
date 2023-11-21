package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220847 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\PassportForWork\\PINComplexity",
                            "attr", "MinimumPINLength",
                            "result_value", "6",
                            "id", "V_220847"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\PassportForWork\\PINComplexity",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\PassportForWork",
                            "attr", "MinimumPINLength",
                            "result_value", "6"
                            
                        ),
                    Map.of(
                            "description", "The system must be configured to prevent IP source routing."
                        )
                );


    public V_220847() {
        pattern = this.policyScriptPattern;
    }


}
