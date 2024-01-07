package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220956: The Access Credential Manager as a trusted caller user right must not be assigned to any groups or accounts.. 
 */
public class V_220956 extends UserRightsStig5 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeTrustedCredManAccessPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeTrustedCredManAccessPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220956"),
            Map.entry("title", "The Access Credential Manager as a trusted caller user right must not be assigned to any groups or accounts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220956r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts are granted the \"Access Credential Manager as a trusted caller\" user right, this is a finding."),
            Map.entry("checkid", "C-22671r555353_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Access Credential Manager as a trusted caller\" to be defined but containing no entries (blank)."),
            Map.entry("fixid", "F-22660r555354_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Access Credential Manager as a trusted caller\" user right may be able to retrieve the credentials of other accounts from Credential Manager."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000005")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220956() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        UserRightsStig1 stig = new V_220956();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
