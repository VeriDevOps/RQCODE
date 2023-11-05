package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220829 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\policies\\Explorer\\",
                            "attr", "NoDriveTypeAutoRun",
                            "result_value", "0x000000ff (255)"
                    ),
                    Map.of(
                            "path", "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\policies\\Explorer\\",
                            "attr", "NoDriveTypeAutoRun",
                            "result_value", "0x000000ff (255)"));


    public V_220829() {
        pattern = this.policyScriptPattern;
    }


}
