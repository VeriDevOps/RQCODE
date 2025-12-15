package rqcode.stigs.win10.UserRights;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220969: The Deny log on as a batch job user right on domain-joined workstations must be configured to prevent access from highly privileged domain accounts.. 
 */
public class V_220969 extends UserRightsStig1 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeDenyBatchLogonRight"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeDenyBatchLogonRight"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220969"),
            Map.entry("title", "The Deny log on as a batch job user right on domain-joined workstations must be configured to prevent access from highly privileged domain accounts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220969r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\n\nVerify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf the following groups or accounts are not defined for the \"Deny log on as a batch job\" right, this is a finding:\n\nDomain Systems Only:\nEnterprise Admin Group\nDomain Admin Group"),
            Map.entry("checkid", "C-22684r555392_chk"),
            Map.entry("fixtext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\n\nConfigure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Deny log on as a batch job\" to include the following.\n\nDomain Systems Only:\nEnterprise Admin Group\nDomain Admin Group"),
            Map.entry("fixid", "F-22673r555393_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nThe \"Deny log on as a batch job\" right defines accounts that are prevented from logging on to the system as a batch job, such as Task Scheduler.\n\nIn an Active Directory Domain, denying logons to the Enterprise Admins and Domain Admins groups on lower trust systems helps mitigate the risk of privilege escalation from credential theft attacks which could lead to the compromise of an entire domain."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000075")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220969() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220969();

        //running command line interface for V_220969
        cli(stig, args);
    }

}
