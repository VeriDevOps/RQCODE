package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220799 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
                            "attr", "LocalAccountTokenFilterPolicy",
                            "result_value", "0",
                            "id", "V_220799"
                    ),
                    Map.of(
                            "path", "HKLM:SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
                            "path_short", "HKLM:SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
                            "attr", "LocalAccountTokenFilterPolicy",
                            "result_value", "0"
                            
                        ),
                    Map.of(
                            "description", "Users must be prevented from changing installation options."
                        )
                );


    public V_220799() {
        pattern = this.policyScriptPattern;
    }


}
