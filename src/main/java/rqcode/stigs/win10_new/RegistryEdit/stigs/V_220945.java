package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220945 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\",
                            "attr", "ConsentPromptBehaviorAdmin",
                            "result_value", "2 (Prompt for consent on the secure desktop)"
                    ),
                    Map.of(
                            "path", "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\",
                            "attr", "ConsentPromptBehaviorAdmin",
                            "result_value", "2 (Prompt for consent on the secure desktop)"));


    public V_220945() {
        pattern = this.policyScriptPattern;
    }


}
