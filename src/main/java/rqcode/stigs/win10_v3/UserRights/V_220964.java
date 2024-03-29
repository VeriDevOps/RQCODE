package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220964: The Create global objects user right must only be assigned to Administrators, Service, Local Service, and Network Service.. 
 */
public class V_220964 extends UserRightsStig3 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeCreateGlobalPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeCreateGlobalPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220964"),
            Map.entry("title", "The Create global objects user right must only be assigned to Administrators, Service, Local Service, and Network Service."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220964r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Create global objects\" user right, this is a finding:\n\nAdministrators\nLOCAL SERVICE\nNETWORK SERVICE\nSERVICE"),
            Map.entry("checkid", "C-22679r555377_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Create global objects\" to only include the following groups or accounts:\n\nAdministrators\nLOCAL SERVICE\nNETWORK SERVICE\nSERVICE"),
            Map.entry("fixid", "F-22668r555378_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Create global objects\" user right can create objects that are available to all sessions, which could affect processes in other users' sessions."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000050")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220964() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220964();

        //running command line interface for V_220964
        cli(stig, args);
    }

}
