package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220796 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters",
                            "attr", "DisableIPSourceRouting",
                            "result_value", "2"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip",
                            "attr", "DisableIPSourceRouting",
                            "result_value", "2"));


    public V_220796() {
        pattern = this.policyScriptPattern;
    }


}
