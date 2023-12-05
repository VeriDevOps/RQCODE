package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220938 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "attr", "LmCompatibilityLevel",
                            "result_value", "5",
                            "id", "V_220938"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
                            "attr", "LmCompatibilityLevel",
                            "result_value", "5"
                            
                        ),
                    Map.of(
                            "description", "Anonymous enumeration of shares must be restricted."
                        )
                );


    public V_220938() {
        pattern = this.policyScriptPattern;
    }


}
