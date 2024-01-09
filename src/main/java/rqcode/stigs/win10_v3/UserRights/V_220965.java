package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220965: The Access Credential Manager as a trusted caller user right must not be assigned to any groups or accounts.. 
 */
public class V_220965 extends UserRightsStig5 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeCreatePermanentPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeCreatePermanentPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220965"),
            Map.entry("title", "The Access Credential Manager as a trusted caller user right must not be assigned to any groups or accounts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220965r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts are granted the \"Create permanent shared objects\" user right, this is a finding."),
            Map.entry("checkid", "C-22671r555353_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Create permanent shared objects\" to be defined but containing no entries (blank)."),
            Map.entry("fixid", "F-22669r555381_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Create permanent shared objects\" user right could expose sensitive data by creating shared objects."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000055")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220965() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220965();

        //running command line interface for V_220965
        cli(stig, args);
    }

}
