package rqcode.stigs.win10.UserRights;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220974: The Force shutdown from a remote system user right must only be assigned to the Administrators group.. 
 */
public class V_220974 extends UserRightsStig2 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeRemoteShutdownPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeRemoteShutdownPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220974"),
            Map.entry("title", "The Force shutdown from a remote system user right must only be assigned to the Administrators group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220974r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Force shutdown from a remote system\" user right, this is a finding:\n\nAdministrators"),
            Map.entry("checkid", "C-22689r555407_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Force shutdown from a remote system\" to only include the following groups or accounts:\n\nAdministrators"),
            Map.entry("fixid", "F-22678r555408_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Force shutdown from a remote system\" user right can remotely shut down a system which could result in a DoS."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000100")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220974() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220974();

        //running command line interface for V_220974
        cli(stig, args);
    }

}
