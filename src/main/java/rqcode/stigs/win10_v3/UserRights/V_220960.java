package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220960: The Back up files and directories user right must only be assigned to the Administrators group.. 
 */
public class V_220960 extends UserRightsStig2 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeBackupPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeBackupPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220960"),
            Map.entry("title", "The Back up files and directories user right must only be assigned to the Administrators group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220960r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Back up files and directories\" user right, this is a finding:\n\nAdministrators"),
            Map.entry("checkid", "C-22675r555365_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Back up files and directories\" to only include the following groups or accounts:\n\nAdministrators"),
            Map.entry("fixid", "F-22664r555366_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Back up files and directories\" user right can circumvent file and directory permissions and could allow access to sensitive data.\""),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000030")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220960() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220960();

        //running command line interface for V_220960
        cli(stig, args);
    }

}
