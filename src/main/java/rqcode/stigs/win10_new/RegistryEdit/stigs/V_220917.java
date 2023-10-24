package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220917 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "", ""
                    ),
                    Map.of(
                            "registryPath", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters\\",
                            "name", "DisablePasswordChange",
                            "type", "DWORD",
                            "value", "0"));

    public V_220917() {
        pattern = this.policyScriptPattern;
    }

    public static void main(String[] args) {
        V_220917 stig = new V_220917();

        System.out.println(stig.check());
    }
}