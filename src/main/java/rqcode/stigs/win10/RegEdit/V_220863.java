package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220863: Systems must at least attempt device authentication using certificates.. 
 */
public class V_220863 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Client",
            "attr", "AllowUnencryptedTraffic",
            "result_value",  "0",
            "id", "V_220863"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Client",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM",
            "attr", "AllowUnencryptedTraffic",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220863"),
            Map.entry("title", "Systems must at least attempt device authentication using certificates."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220863r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Client\\\n\nValue Name: AllowUnencryptedTraffic\n\nValue Type: REG_DWORD\nValue: 0"),
            Map.entry("checkid", "C-22578r555074_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Remote Management (WinRM) >> WinRM Client >> \"Allow unencrypted traffic\" to \"Disabled\"."),
            Map.entry("fixid", "F-22567r555075_fix"),
            Map.entry("description","Unencrypted remote access to a system can allow sensitive information to be compromised.  Windows remote management connections must be encrypted to prevent this."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000335")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220863() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220863();

        //running command line interface for V_220863
        cli(stig, args);
    }

}
