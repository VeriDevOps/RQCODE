package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220924: The Smart Card removal option must be configured to Force Logoff or Lock Workstation.
 *
 * NOTE: the STIG accepts SCRemoveOption values of 1 (Lock Workstation) or 2 (Force Logoff). This class checks for 1, the less disruptive of the two compliant values.
 */
public class V_220924 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon",
            "attr", "SCRemoveOption",
            "result_value",  "1",
            "id", "V_220924"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion",
            "attr", "SCRemoveOption",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220924"),
            Map.entry("title", "The Smart Card removal option must be configured to Force Logoff or Lock Workstation."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220924r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive:  HKEY_LOCAL_MACHINE\nRegistry Path:  \\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\\n\nValue Name:  SCRemoveOption\n\nValue Type:  REG_SZ\nValue:  1 (Lock Workstation) or 2 (Force Logoff)\n\nThis can be left not configured or set to \"No action\" on workstations with the following conditions.  This must be documented with the ISSO.\n-The setting cannot be configured due to mission needs, or because it interferes with applications.\n-Policy must be in place that users manually lock workstations when leaving them unattended.\n-The screen saver is properly configured to lock as required."),
            Map.entry("checkid", "C-22639r555257_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Interactive logon: Smart card removal behavior\" to  \"Lock Workstation\" or \"Force Logoff\"."),
            Map.entry("fixid", "F-22628r555258_fix"),
            Map.entry("description", "Unattended systems are susceptible to unauthorized use and must be locked.  Configuring a system to lock when a smart card is removed will ensure the system is inaccessible when unattended."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000095")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220924() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220924();

        //running command line interface for V_220924
        cli(stig, args);
    }

}
