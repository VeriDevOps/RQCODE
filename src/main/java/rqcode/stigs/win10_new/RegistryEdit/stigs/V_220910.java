package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220910 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "attr", "LimitBlankPasswordUse",
                            "result_value", "1",
                            "id", "V_220910"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
                            "attr", "LimitBlankPasswordUse",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "Passwords must not be saved in the Remote Desktop Client."
                        )
                );


    public V_220910() {
        pattern = this.policyScriptPattern;
    }


}
