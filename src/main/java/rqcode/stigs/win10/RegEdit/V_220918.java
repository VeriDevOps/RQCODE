package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220918: The maximum age for machine account passwords must be configured to 30 days or less.
 *
 * NOTE: the STIG requires a value of 30 or less (excluding 0). This class checks for the documented default of 30.
 */
public class V_220918 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "attr", "MaximumPasswordAge",
            "result_value",  "30",
            "id", "V_220918"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon",
            "attr", "MaximumPasswordAge",
            "result_value", "30"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220918"),
            Map.entry("title", "The maximum age for machine account passwords must be configured to 30 days or less."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220918r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "This is the default configuration for this setting (30 days).\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters\\\n\nValue Name: MaximumPasswordAge\n\nValue Type: REG_DWORD\nValue: 0x0000001e (30)  (or less, excluding 0)"),
            Map.entry("checkid", "C-22633r555239_chk"),
            Map.entry("fixtext", "This is the default configuration for this setting (30 days).\n\nConfigure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Domain member: Maximum machine account password age\" to \"30\" or less (excluding 0 which is unacceptable)."),
            Map.entry("fixid", "F-22622r555240_fix"),
            Map.entry("description", "Computer account passwords are changed automatically on a regular basis.  This setting controls the maximum password age that a machine account may have.  This setting must be set to no more than 30 days, ensuring the machine changes its password monthly."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000055")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220918() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220918();

        //running command line interface for V_220918
        cli(stig, args);
    }

}
