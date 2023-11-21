package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220842 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Internet Settings",
                            "attr", "PreventCertErrorOverrides",
                            "result_value", "1",
                            "id", "V_220842"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Internet Settings",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge",
                            "attr", "PreventCertErrorOverrides",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "The Windows Remote Management (WinRM) service must not allow unencrypted traffic."
                        )
                );


    public V_220842() {
        pattern = this.policyScriptPattern;
    }


}
