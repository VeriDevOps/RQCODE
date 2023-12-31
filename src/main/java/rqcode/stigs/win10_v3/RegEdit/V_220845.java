package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220845: The display of slide shows on the lock screen must be disabled.. 
 */
public class V_220845 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\GameDVR",
            "attr", "AllowGameDVR",
            "result_value",  "0",
            "id", "V_220845"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\GameDVR",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "AllowGameDVR",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220845"),
            Map.entry("title", "The display of slide shows on the lock screen must be disabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220845r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This is NA for Windows 10 LTSC\\B versions 1507 and 1607.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\GameDVR\\\n\nValue Name: AllowGameDVR\n\nType: REG_DWORD\nValue: 0x00000000 (0)"),
            Map.entry("checkid", "C-22560r555020_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Game Recording and Broadcasting >> \"Enables or disables Windows Game Recording and Broadcasting\" to \"Disabled\"."),
            Map.entry("fixid", "F-22549r555021_fix"),
            Map.entry("description","Windows Game Recording and Broadcasting is intended for use with games, however it could potentially record screen shots of other applications and expose sensitive data.  Disabling the feature will prevent this from occurring."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000252")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220845() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220845();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
