package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220955 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Attachments\\",
                            "attr", "SaveZoneInformation",
                            "result_value", "0x00000002 (2) (or if the attr does not exist)"
                    ),
                    Map.of(
                            "path", "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Attachments\\",
                            "attr", "SaveZoneInformation",
                            "result_value", "0x00000002 (2) (or if the attr does not exist)"));


    public V_220955() {
        pattern = this.policyScriptPattern;
    }


}
