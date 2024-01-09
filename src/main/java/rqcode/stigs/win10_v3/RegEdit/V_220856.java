package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220856: The maximum age for machine account passwords must be configured to 30 days or less.. 
 */
public class V_220856 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer",
            "attr", "EnableUserControl",
            "result_value",  "0",
            "id", "V_220856"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "EnableUserControl",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220856"),
            Map.entry("title", "The maximum age for machine account passwords must be configured to 30 days or less."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220856r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer\\\n\nValue Name: EnableUserControl\n\nValue Type: REG_DWORD\nValue: 0"),
            Map.entry("checkid", "C-22571r555053_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Installer >> \"Allow user control over installs\" to \"Disabled\"."),
            Map.entry("fixid", "F-22560r555054_fix"),
            Map.entry("description","Installation options for applications are typically controlled by administrators.  This setting prevents users from changing installation options that may bypass security features."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000310")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220856() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220856();

        //running command line interface for V_220856
        cli(stig, args);
    }

}
