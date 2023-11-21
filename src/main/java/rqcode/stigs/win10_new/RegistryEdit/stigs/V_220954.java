package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220954 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CurrentVersion\\PushNotifications",
                            "attr", "NoToastApplicationNotificationOnLockScreen",
                            "result_value", "1",
                            "id", "V_220954"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CurrentVersion\\PushNotifications",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CurrentVersion",
                            "attr", "NoToastApplicationNotificationOnLockScreen",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "PowerShell Transcription must be enabled on Windows 10."
                        )
                );


    public V_220954() {
        pattern = this.policyScriptPattern;
    }


}
