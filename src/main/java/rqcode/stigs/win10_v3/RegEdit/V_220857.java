package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220857: Structured Exception Handling Overwrite Protection (SEHOP) must be enabled.. 
 */
public class V_220857 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer",
            "attr", "AlwaysInstallElevated",
            "result_value",  "0",
            "id", "V_220857"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "AlwaysInstallElevated",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220857"),
            Map.entry("title", "Structured Exception Handling Overwrite Protection (SEHOP) must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220857r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer\\\n\nValue Name: AlwaysInstallElevated\n\nValue Type: REG_DWORD\nValue: 0"),
            Map.entry("checkid", "C-22572r555056_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Installer >> \"Always install with elevated privileges\" to \"Disabled\"."),
            Map.entry("fixid", "F-22561r555057_fix"),
            Map.entry("description","Standard user accounts must not be granted elevated privileges.  Enabling Windows Installer to elevate privileges when installing applications can allow malicious persons and applications to gain full control of a system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000315")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220857() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220857();

        //running command line interface for V_220857
        cli(stig, args);
    }

}
