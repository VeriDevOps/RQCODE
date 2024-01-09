package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220966: The Create symbolic links user right must only be assigned to the Administrators group.. 
 */
public class V_220966 extends UserRightsStig2 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeCreateSymbolicLinkPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeCreateSymbolicLinkPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220966"),
            Map.entry("title", "The Create symbolic links user right must only be assigned to the Administrators group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220966r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Create symbolic links\" user right, this is a finding:\n\nAdministrators\n\nIf the workstation has an approved use of Hyper-V, such as being used as a dedicated admin workstation using Hyper-V to separate administration and standard user functions, \"NT VIRTUAL MACHINES\\VIRTUAL MACHINE\" may be assigned this user right and is not a finding."),
            Map.entry("checkid", "C-22681r555383_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Create symbolic links\" to only include the following groups or accounts:\n\nAdministrators"),
            Map.entry("fixid", "F-22670r555384_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Create symbolic links\" user right can create pointers to other objects, which could potentially expose the system to attack."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000060")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220966() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220966();

        //running command line interface for V_220966
        cli(stig, args);
    }

}
