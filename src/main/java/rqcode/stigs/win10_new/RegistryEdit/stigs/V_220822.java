package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220822 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings\\0e796bdb-100d-47d6-a2d5-f7d2daa51f51",
                            "attr", "ACSettingIndex",
                            "result_value", "1",
                            "id", "V_220822"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings\\0e796bdb-100d-47d6-a2d5-f7d2daa51f51",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings",
                            "attr", "ACSettingIndex",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "The LanMan authentication level must be set to send NTLMv2 response only, and to refuse LM and NTLM."
                        )
                );


    public V_220822() {
        pattern = this.policyScriptPattern;
    }


}
