package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220869: Windows 10 must be configured to prevent Windows apps from being activated by voice while the system is locked.
 *
 * NOTE: the STIG also treats the system as Not Applicable when a separate policy (LetAppsActivateWithVoice = 2) disables voice activation altogether. That alternate NA condition is not modeled here; this class checks only the primary compliant configuration.
 */
public class V_220869 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\AppPrivacy",
            "attr", "LetAppsActivateWithVoiceAboveLock",
            "result_value",  "2",
            "id", "V_220869"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\AppPrivacy",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "LetAppsActivateWithVoiceAboveLock",
            "result_value", "2"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220869"),
            Map.entry("title", "Windows 10 must be configured to prevent Windows apps from being activated by voice while the system is locked."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220869r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This setting requires v1903 or later of Windows 10; it is NA for prior versions.  The setting is NA when the \u201cAllow voice activation\u201d policy is configured to disallow applications to be activated with voice for all users.\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\AppPrivacy\\\n\nValue Name: LetAppsActivateWithVoiceAboveLock\n\nType: REG_DWORD\nValue: 0x00000002 (2)\n\nIf the following registry value exists and is configured as specified, requirement is NA. \n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\AppPrivacy\\\n\nValue Name: LetAppsActivateWithVoice\n\nType: REG_DWORD\nValue: 0x00000002 (2)"),
            Map.entry("checkid", "C-22584r555092_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> App Privacy >> \"Let Windows apps activate with voice while the system is locked\" to \"Enabled\" with \u201cDefault for all Apps:\u201d set to \u201cForce Deny\u201d. \n\nThe requirement is NA if the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> App Privacy >> \"Let Windows apps activate with voice\" is configured to \"Enabled\" with \u201cDefault for all Apps:\u201d set to \u201cForce Deny\u201d."),
            Map.entry("fixid", "F-22573r555093_fix"),
            Map.entry("description", "Allowing Windows apps to be activated by voice from the lock screen could allow for unauthorized use. Requiring logon will ensure the apps are only used by authorized personnel."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000365")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220869() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220869();

        //running command line interface for V_220869
        cli(stig, args);
    }

}
