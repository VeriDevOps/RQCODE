package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220976: The Load and unload device drivers user right must only be assigned to the Administrators group.. 
 */
public class V_220976 extends UserRightsStig2 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeLoadDriverPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeLoadDriverPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220976"),
            Map.entry("title", "The Load and unload device drivers user right must only be assigned to the Administrators group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220976r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Load and unload device drivers\" user right, this is a finding:\n\nAdministrators"),
            Map.entry("checkid", "C-22691r555413_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Load and unload device drivers\" to only include the following groups or accounts:\n\nAdministrators"),
            Map.entry("fixid", "F-22680r555414_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nThe \"Load and unload device drivers\" user right allows device drivers to dynamically be loaded on a system by a user. This could potentially be used to install malicious code by an attacker."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000120")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220976() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220976();

        //running command line interface for V_220976
        cli(stig, args);
    }

}
