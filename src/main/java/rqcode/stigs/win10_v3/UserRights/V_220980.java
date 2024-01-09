package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220980: The Perform volume maintenance tasks user right must only be assigned to the Administrators group.. 
 */
public class V_220980 extends UserRightsStig2 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeManageVolumePrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeManageVolumePrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220980"),
            Map.entry("title", "The Perform volume maintenance tasks user right must only be assigned to the Administrators group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220980r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Perform volume maintenance tasks\" user right, this is a finding:\n\nAdministrators"),
            Map.entry("checkid", "C-22695r555425_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Perform volume maintenance tasks\" to only include the following groups or accounts:\n\nAdministrators"),
            Map.entry("fixid", "F-22684r555426_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Perform volume maintenance tasks\" user right can manage volume and disk configurations. They could potentially delete volumes, resulting in, data loss or a DoS."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000145")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220980() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220980();

        //running command line interface for V_220980
        cli(stig, args);
    }

}
