package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220917: Local accounts with blank passwords must be restricted to prevent access from the network.. 
 */
public class V_220917 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "attr", "DisablePasswordChange",
            "result_value",  "0",
            "id", "V_220917"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon",
            "attr", "DisablePasswordChange",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220917"),
            Map.entry("title", "Local accounts with blank passwords must be restricted to prevent access from the network."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220917r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters\\\n\nValue Name: DisablePasswordChange\n\nValue Type: REG_DWORD\nValue: 0"),
            Map.entry("checkid", "C-22632r555236_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Domain member: Disable machine account password changes\" to \"Disabled\"."),
            Map.entry("fixid", "F-22621r555237_fix"),
            Map.entry("description","Computer account passwords are changed automatically on a regular basis.  Disabling automatic password changes can make the system more vulnerable to malicious access.  Frequent password changes can be a significant safeguard for your system.  A new password for the computer account will be generated every 30 days."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000050")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220917() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220917();

        //running command line interface for V_220917
        cli(stig, args);
    }

}
