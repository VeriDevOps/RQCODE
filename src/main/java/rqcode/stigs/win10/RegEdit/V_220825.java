package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220825: The setting to allow Microsoft accounts to be optional for modern style apps must be enabled.
 */
public class V_220825 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "attr", "MSAOptional",
            "result_value",  "1",
            "id", "V_220825"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "MSAOptional",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220825"),
            Map.entry("title", "The setting to allow Microsoft accounts to be optional for modern style apps must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220825r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "Windows 10 LTSC\\B versions do not support the Microsoft Store and modern apps; this is NA for those systems.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\\n\nValue Name: MSAOptional\n\nValue Type: REG_DWORD\nValue: 0x00000001 (1)"),
            Map.entry("checkid", "C-22540r554960_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> App Runtime >> \"Allow Microsoft accounts to be optional\" to \"Enabled\"."),
            Map.entry("fixid", "F-22529r554961_fix"),
            Map.entry("description", "Control of credentials and the system must be maintained within the enterprise.  Enabling this setting allows enterprise credentials to be used with modern style apps that support this, instead of Microsoft accounts."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000170")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220825() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220825();

        //running command line interface for V_220825
        cli(stig, args);
    }

}
