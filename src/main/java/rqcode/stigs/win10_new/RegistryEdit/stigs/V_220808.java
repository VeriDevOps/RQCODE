package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220808 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Microsoft\\WcmSvc\\wifinetworkmanager\\config",
                            "attr", "AutoConnectAllowedOEM",
                            "result_value", "0",
                            "id", "V_220808"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Microsoft\\WcmSvc\\wifinetworkmanager\\config",
                            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\WcmSvc\\wifinetworkmanager",
                            "attr", "AutoConnectAllowedOEM",
                            "result_value", "0"
                            
                        ),
                    Map.of(
                            "description", "Printing over HTTP must be prevented."
                        )
                );


    public V_220808() {
        pattern = this.policyScriptPattern;
    }


}
