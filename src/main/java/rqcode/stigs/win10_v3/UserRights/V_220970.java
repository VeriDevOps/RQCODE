package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220970: The Deny log on as a service user right on Windows 10 domain-joined workstations must be configured to prevent access from highly privileged domain accounts.. 
 */
public class V_220970 extends UserRightsStig1 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeDenyServiceLogonRight"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeDenyServiceLogonRight"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220970"),
            Map.entry("title", "The Deny log on as a service user right on Windows 10 domain-joined workstations must be configured to prevent access from highly privileged domain accounts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220970r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\n\nVerify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf the following groups or accounts are not defined for the \"Deny log on as a service\" right , this is a finding:\n\nDomain Systems Only:\nEnterprise Admins Group\nDomain Admins Group"),
            Map.entry("checkid", "C-22685r555395_chk"),
            Map.entry("fixtext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\n\nConfigure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Deny log on as a service\" to include the following.\n\nDomain Systems Only:\nEnterprise Admins Group\nDomain Admins Group"),
            Map.entry("fixid", "F-22674r555396_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nThe \"Deny log on as a service\" right defines accounts that are denied log on as a service.\n\nIn an Active Directory Domain, denying logons to the Enterprise Admins and Domain Admins groups on lower trust systems helps mitigate the risk of privilege escalation from credential theft attacks which could lead to the compromise of an entire domain.\n\nIncorrect configurations could prevent services from starting and result in a DoS."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000080")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220970() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        UserRightsStig1 stig = new V_220970();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
