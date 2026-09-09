package rqcode.stigs.win10.UserRights;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220961: The Change the system time user right must only be assigned to Administrators and Local Service and NT SERVICE\\autotimesvc.
 */
public class V_220961 extends UserRightsStig7 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeSystemtimePrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeSystemtimePrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220961"),
            Map.entry("title", "The Change the system time user right must only be assigned to Administrators and Local Service and NT SERVICE\\autotimesvc."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220961r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Change the system time\" user right, this is a finding:\n\nAdministrators\nLOCAL SERVICE\nNT SERVICE\\autotimesvc is added in v1909 cumulative update."),
            Map.entry("checkid", "C-22676r555368_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Change the system time\" to only include the following groups or accounts:\n\nAdministrators\nLOCAL SERVICE\nNT SERVICE\\autotimesvc is added in v1909 cumulative update."),
            Map.entry("fixid", "F-22665r555369_fix"),
            Map.entry("description", "Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Change the system time\" user right can change the system time, which can impact authentication, as well as affect time stamps on event log entries.\n\nThe NT SERVICE\\autotimesvc is added in v1909 cumulative update. "),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000035")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220961() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220961();

        //running command line interface for V_220961
        cli(stig, args);
    }

}
