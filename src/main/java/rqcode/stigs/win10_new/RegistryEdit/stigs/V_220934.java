package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220934 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\LSA\\MSV1_0",
                            "attr", "allownullsessionfallback",
                            "result_value", "0",
                            "id", "V_220934"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\LSA\\MSV1_0",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\LSA",
                            "attr", "allownullsessionfallback",
                            "result_value", "0"));


    public V_220934() {
        pattern = this.policyScriptPattern;
    }


}
