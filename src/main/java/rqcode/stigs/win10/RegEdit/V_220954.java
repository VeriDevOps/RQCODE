package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220954: PowerShell Transcription must be enabled on Windows 10.. 
 */
public class V_220954 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CurrentVersion\\PushNotifications",
            "attr", "NoToastApplicationNotificationOnLockScreen",
            "result_value",  "1",
            "id", "V_220954"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CurrentVersion\\PushNotifications",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CurrentVersion",
            "attr", "NoToastApplicationNotificationOnLockScreen",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220954"),
            Map.entry("title", "PowerShell Transcription must be enabled on Windows 10."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220954r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_CURRENT_USER\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\CurrentVersion\\PushNotifications\\\n\nValue Name: NoToastApplicationNotificationOnLockScreen\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22669r555347_chk"),
            Map.entry("fixtext", "Configure the policy value for User Configuration >> Administrative Templates >> Start Menu and Taskbar >> Notifications >> \"Turn off toast notifications on the lock screen\" to \"Enabled\"."),
            Map.entry("fixid", "F-22658r555348_fix"),
            Map.entry("description","Toast notifications that are displayed on the lock screen could display sensitive information to unauthorized personnel.  Turning off this feature will limit access to the information to a logged on user."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UC-000015")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220954() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220954();

        //running command line interface for V_220954
        cli(stig, args);
    }

}
