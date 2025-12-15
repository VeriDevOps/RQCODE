package rqcode.stigs.win10.UserRights;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220973: The Access Credential Manager as a trusted caller user right must not be assigned to any groups or accounts.. 
 */
public class V_220973 extends UserRightsStig5 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeEnableDelegationPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeEnableDelegationPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220973"),
            Map.entry("title", "The Access Credential Manager as a trusted caller user right must not be assigned to any groups or accounts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220973r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts are granted the \"Enable computer and user accounts to be trusted for delegation\" user right, this is a finding."),
            Map.entry("checkid", "C-22671r555353_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Enable computer and user accounts to be trusted for delegation\" to be defined but containing no entries (blank)."),
            Map.entry("fixid", "F-22677r555405_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nThe \"Enable computer and user accounts to be trusted for delegation\" user right allows the \"Trusted for Delegation\" setting to be changed. This could potentially allow unauthorized users to impersonate other users."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000095")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220973() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220973();

        //running command line interface for V_220973
        cli(stig, args);
    }

}
