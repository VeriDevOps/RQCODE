package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220815: The Windows Remote Management (WinRM) client must not allow unencrypted traffic.. 
 */
public class V_220815 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Printers",
            "attr", "DisableWebPnPDownload",
            "result_value",  "1",
            "id", "V_220815"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Printers",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT",
            "attr", "DisableWebPnPDownload",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220815"),
            Map.entry("title", "The Windows Remote Management (WinRM) client must not allow unencrypted traffic."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220815r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Printers\\\n\nValue Name: DisableWebPnPDownload\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22530r554930_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Internet Communication Management >> Internet Communication settings >> \"Turn off downloading of print drivers over HTTP\" to \"Enabled\"."),
            Map.entry("fixid", "F-22519r554931_fix"),
            Map.entry("description","Some features may communicate with the vendor, sending system information or downloading data or components for the feature.  Turning off this capability will prevent potentially sensitive information from being sent outside the enterprise and uncontrolled updates to the system.  This setting prevents the computer from downloading print driver packages over HTTP."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000100")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220815() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220815();

        //running command line interface for V_220815
        cli(stig, args);
    }

}
