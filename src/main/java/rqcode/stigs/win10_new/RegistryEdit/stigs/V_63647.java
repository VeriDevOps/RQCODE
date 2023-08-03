package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_63647 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "", ""
                    ),
                    Map.of(
                            "registryPath", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
                            "name", "SignSecureChannel",
                            "type", "DWORD",
                            "value", "1"));

    public V_63647() {
        pattern = this.policyScriptPattern;
    }
}
