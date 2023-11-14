package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220730 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanmanServer\\Parameters",
                            "attr", "SMB1",
                            "result_value", "0x00000000 (0)"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanmanServer\\Parameters",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanmanServer",
                            "attr", "SMB1",
                            "result_value", "0x00000000 (0)"));


    public V_220730() {
        pattern = this.policyScriptPattern;
    }


}
