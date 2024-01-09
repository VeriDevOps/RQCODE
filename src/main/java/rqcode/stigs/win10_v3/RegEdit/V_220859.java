package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220859: Outgoing secure channel traffic must be encrypted or signed.. 
 */
public class V_220859 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "attr", "DisableAutomaticRestartSignOn",
            "result_value",  "1",
            "id", "V_220859"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "DisableAutomaticRestartSignOn",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220859"),
            Map.entry("title", "Outgoing secure channel traffic must be encrypted or signed."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220859r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\\n\nValue Name: DisableAutomaticRestartSignOn\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22574r555062_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Logon Options >> \"Sign-in last interactive user automatically after a system-initiated restart\" to \"Disabled\"."),
            Map.entry("fixid", "F-22563r555063_fix"),
            Map.entry("description","Windows can be configured to automatically sign the user back in after a Windows Update restart.  Some protections are in place to help ensure this is done in a secure fashion; however, disabling this will prevent the caching of credentials for this purpose and also ensure the user is aware of the restart."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000325")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220859() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220859();

        //running command line interface for V_220859
        cli(stig, args);
    }

}
