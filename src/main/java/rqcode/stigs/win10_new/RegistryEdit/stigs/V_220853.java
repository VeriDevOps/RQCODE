package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220853 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Internet Explorer\\Feeds",
                            "attr", "DisableEnclosureDownload",
                            "result_value", "1",
                            "id", "V_220853"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Internet Explorer\\Feeds",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Internet Explorer",
                            "attr", "DisableEnclosureDownload",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "The System event log size must be configured to 32768 KB or greater."
                        )
                );


    public V_220853() {
        pattern = this.policyScriptPattern;
    }


}
