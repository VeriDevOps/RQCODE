package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220940 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0",
                            "attr", "NTLMMinClientSec",
                            "result_value", "0x20080000 (537395200)"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "attr", "NTLMMinClientSec",
                            "result_value", "0x20080000 (537395200)"));


    public V_220940() {
        pattern = this.policyScriptPattern;
    }


}