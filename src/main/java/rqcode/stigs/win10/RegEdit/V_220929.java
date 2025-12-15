package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220929: PowerShell script block logging must be enabled on Windows 10.. 
 */
public class V_220929 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "attr", "RestrictAnonymousSAM",
            "result_value",  "1",
            "id", "V_220929"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
            "attr", "RestrictAnonymousSAM",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220929"),
            Map.entry("title", "PowerShell script block logging must be enabled on Windows 10."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220929r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Lsa\\\n\nValue Name: RestrictAnonymousSAM\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22644r555272_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network access: Do not allow anonymous enumeration of SAM accounts\" to \"Enabled\"."),
            Map.entry("fixid", "F-22633r555273_fix"),
            Map.entry("description","Anonymous enumeration of SAM accounts allows anonymous log on users (null session connections) to list all accounts names, thus providing a list of potential points to attack the system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000145")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220929() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220929();

        //running command line interface for V_220929
        cli(stig, args);
    }

}
