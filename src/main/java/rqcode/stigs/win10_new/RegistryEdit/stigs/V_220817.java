package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220817 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Printers\\",
                            "attr", "DisableHTTPPrinting",
                            "result_value", "1"
                    ),
                    Map.of(
                            "path", "\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Printers\\",
                            "attr", "DisableHTTPPrinting",
                            "result_value", "1"));


    public V_220817() {
        pattern = this.policyScriptPattern;
    }


}
