package rqcode.stigs.win10.UserRights;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220978: The Manage auditing and security log user right must only be assigned to the Administrators group.. 
 */
public class V_220978 extends UserRightsStig2 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeSecurityPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeSecurityPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220978"),
            Map.entry("title", "The Manage auditing and security log user right must only be assigned to the Administrators group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220978r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Manage auditing and security log\" user right, this is a finding:\n\nAdministrators\n\nIf the organization has an \"Auditors\" group the assignment of this group to the user right would not be a finding."),
            Map.entry("checkid", "C-22693r555419_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Manage auditing and security log\" to only include the following groups or accounts:\n\nAdministrators"),
            Map.entry("fixid", "F-22682r555420_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Manage auditing and security log\" user right can manage the security log and change auditing configurations. This could be used to clear evidence of tampering."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000130")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220978() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220978();

        //running command line interface for V_220978
        cli(stig, args);
    }

}
