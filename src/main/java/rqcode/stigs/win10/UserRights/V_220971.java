package rqcode.stigs.win10.UserRights;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220971: The Deny log on locally user right on workstations must be configured to prevent access from highly privileged domain accounts on domain systems and unauthenticated access on all systems.. 
 */
public class V_220971 extends UserRightsStig1 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeDenyInteractiveLogonRight"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeDenyInteractiveLogonRight"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220971"),
            Map.entry("title", "The Deny log on locally user right on workstations must be configured to prevent access from highly privileged domain accounts on domain systems and unauthenticated access on all systems."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220971r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\n\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf the following groups or accounts are not defined for the \"Deny log on locally\" right, this is a finding.\n\nDomain Systems Only:\nEnterprise Admins Group\nDomain Admins Group\n\nPrivileged Access Workstations (PAWs) dedicated to the management of Active Directory are exempt from denying the Enterprise Admins and Domain Admins groups. (See the Windows Privileged Access Workstation STIG for PAW requirements.)\n\nAll Systems:\nGuests Group"),
            Map.entry("checkid", "C-22686r555398_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Deny log on locally\" to include the following.\n\nDomain Systems Only:\nEnterprise Admins Group\nDomain Admins Group\n\nPrivileged Access Workstations (PAWs) dedicated to the management of Active Directory are exempt from denying the Enterprise Admins and Domain Admins groups. (See the Windows Privileged Access Workstation STIG for PAW requirements.)\n\nAll Systems:\nGuests Group"),
            Map.entry("fixid", "F-22675r555399_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high-level capabilities.\n\nThe \"Deny log on locally\" right defines accounts that are prevented from logging on interactively.\n\nIn an Active Directory Domain, denying logons to the Enterprise Admins and Domain Admins groups on lower trust systems helps mitigate the risk of privilege escalation from credential theft attacks, which could lead to the compromise of an entire domain.\n\nThe Guests group must be assigned this right to prevent unauthenticated access."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000085")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220971() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220971();

        //running command line interface for V_220971
        cli(stig, args);
    }

}
