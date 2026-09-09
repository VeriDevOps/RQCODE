package rqcode.stigs.win10.UserRights;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220959: The Allow log on locally user right must only be assigned to the Administrators and Users groups.
 */
public class V_220959 extends UserRightsStig6 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeInteractiveLogonRight"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeInteractiveLogonRight"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220959"),
            Map.entry("title", "The Allow log on locally user right must only be assigned to the Administrators and Users groups."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220959r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\n\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Allow log on locally\" user right, this is a finding:\n\nAdministrators\nUsers"),
            Map.entry("checkid", "C-22674r555362_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Allow log on locally\" to only include the following groups or accounts:\n\nAdministrators\nUsers"),
            Map.entry("fixid", "F-22663r555363_fix"),
            Map.entry("description", "Inappropriate granting of user rights can provide system, administrative, and other high-level capabilities.\n\nAccounts with the \"Allow log on locally\" user right can log on interactively to a system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000025")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220959() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220959();

        //running command line interface for V_220959
        cli(stig, args);
    }

}
