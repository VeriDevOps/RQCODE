package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220827 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer",
                            "attr", "NoAutoplayfornonVolume",
                            "result_value", "1",
                            "id", "V_220827"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
                            "attr", "NoAutoplayfornonVolume",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "Toast notifications to the lock screen must be turned off."
                        )
                );


    public V_220827() {
        pattern = this.policyScriptPattern;
    }


}
