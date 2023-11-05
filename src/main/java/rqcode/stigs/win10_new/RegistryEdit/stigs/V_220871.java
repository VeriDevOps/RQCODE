package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220871 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "\\Software\\Policies\\Microsoft\\WindowsInkWorkspace",
                            "attr", "AllowWindowsInkWorkspace",
                            "result_value", "1"
                    ),
                    Map.of(
                            "path", "\\Software\\Policies\\Microsoft\\WindowsInkWorkspace",
                            "attr", "AllowWindowsInkWorkspace",
                            "result_value", "1"));


    public V_220871() {
        pattern = this.policyScriptPattern;
    }


}
