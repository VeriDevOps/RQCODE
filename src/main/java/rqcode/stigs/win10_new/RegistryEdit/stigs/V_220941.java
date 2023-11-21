package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220941 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0",
                            "attr", "NTLMMinServerSec",
                            "result_value", "537395200",
                            "id", "V_220941"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "attr", "NTLMMinServerSec",
                            "result_value", "537395200"
                            
                        ),
                    Map.of(
                            "description", "The convenience PIN for Windows 10 must be disabled."
                        )
                );


    public V_220941() {
        pattern = this.policyScriptPattern;
    }


}
