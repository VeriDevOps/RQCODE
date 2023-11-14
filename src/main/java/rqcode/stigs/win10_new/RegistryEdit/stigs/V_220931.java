package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220931 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "attr", "EveryoneIncludesAnonymous",
                            "result_value", "0"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
                            "attr", "EveryoneIncludesAnonymous",
                            "result_value", "0"));


    public V_220931() {
        pattern = this.policyScriptPattern;
    }


}