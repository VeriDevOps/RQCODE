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
                            "path", "HKLM:\\Software\\Policies\\Microsoft\\WindowsInkWorkspac",
                            "attr", "AllowWindowsInkWorkspace",
                            "result_value", "1",
                            "id", "V_220871"
                    ),
                    Map.of(
                            "path", "HKLM:\\Software\\Policies\\Microsoft\\WindowsInkWorkspac",
                            "path_short", "HKLM:\\Software\\Policies\\Microsoft",
                            "attr", "AllowWindowsInkWorkspace",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "The use of a hardware security device with Windows Hello for Business must be enabled."
                        )
                );


    public V_220871() {
        pattern = this.policyScriptPattern;
    }


}
