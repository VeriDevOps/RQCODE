package rqcode.stigs.win10.UserRights;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220977: The Lock pages in memory user right must not be assigned to any groups or accounts.
 */
public class V_220977 extends UserRightsStig5 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeLockMemoryPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeLockMemoryPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220977"),
            Map.entry("title", "The Lock pages in memory user right must not be assigned to any groups or accounts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220977r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts are granted the \"Lock pages in memory\" user right, this is a finding."),
            Map.entry("checkid", "C-22692r555416_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Lock pages in memory\" to be defined but containing no entries (blank)."),
            Map.entry("fixid", "F-22681r555417_fix"),
            Map.entry("description", "Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nThe \"Lock pages in memory\" user right allows physical memory to be assigned to processes, which could cause performance issues or a DoS."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000125")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220977() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220977();

        //running command line interface for V_220977
        cli(stig, args);
    }

}
