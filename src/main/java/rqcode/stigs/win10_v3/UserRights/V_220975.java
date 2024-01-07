package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220975: The Impersonate a client after authentication user right must only be assigned to Administrators, Service, Local Service, and Network Service.. 
 */
public class V_220975 extends UserRightsStig3 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeImpersonatePrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeImpersonatePrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220975"),
            Map.entry("title", "The Impersonate a client after authentication user right must only be assigned to Administrators, Service, Local Service, and Network Service."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220975r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Impersonate a client after authentication\" user right, this is a finding:\n\nAdministrators\nLOCAL SERVICE\nNETWORK SERVICE\nSERVICE"),
            Map.entry("checkid", "C-22690r555410_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Impersonate a client after authentication\" to only include the following groups or accounts:\n\nAdministrators\nLOCAL SERVICE\nNETWORK SERVICE\nSERVICE"),
            Map.entry("fixid", "F-22679r555411_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nThe \"Impersonate a client after authentication\" user right allows a program to impersonate another user or account to run on their behalf. An attacker could potentially use this to elevate privileges."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000110")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220975() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        UserRightsStig1 stig = new V_220975();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
