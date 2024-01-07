package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220968: The Deny access to this computer from the network user right on workstations must be configured to prevent access from highly privileged domain accounts and local accounts on domain systems and unauthenticated access on all systems.. 
 */
public class V_220968 extends UserRightsStig4 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeDenyNetworkLogonRight"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeDenyNetworkLogonRight"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220968"),
            Map.entry("title", "The Deny access to this computer from the network user right on workstations must be configured to prevent access from highly privileged domain accounts and local accounts on domain systems and unauthenticated access on all systems."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220968r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\n\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf the following groups or accounts are not defined for the \"Deny access to this computer from the network\" right, this is a finding:\n\nDomain Systems Only:\nEnterprise Admins group\nDomain Admins group\nLocal account (see Note below)\n\nAll Systems:\nGuests group\n\nPrivileged Access Workstations (PAWs) dedicated to the management of Active Directory are exempt from denying the Enterprise Admins and Domain Admins groups. (See the Windows Privileged Access Workstation STIG for PAW requirements.)\n\nNote: \"Local account\" is a built-in security group used to assign user rights and permissions to all local accounts."),
            Map.entry("checkid", "C-22683r555389_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Deny access to this computer from the network\" to include the following.\n\nDomain Systems Only:\nEnterprise Admins group\nDomain Admins group\nLocal account (see Note below)\n\nAll Systems:\nGuests group\n\nPrivileged Access Workstations (PAWs) dedicated to the management of Active Directory are exempt from denying the Enterprise Admins and Domain Admins groups. (See the Windows Privileged Access Workstation STIG for PAW requirements.)\n\nNote: \"Local account\" is a built-in security group used to assign user rights and permissions to all local accounts."),
            Map.entry("fixid", "F-22672r555390_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high-level capabilities.\n\nThe \"Deny access to this computer from the network\" right defines the accounts that are prevented from logging on from the network.\n\nIn an Active Directory Domain, denying logons to the Enterprise Admins and Domain Admins groups on lower trust systems helps mitigate the risk of privilege escalation from credential theft attacks, which could lead to the compromise of an entire domain.\n\nLocal accounts on domain-joined systems must also be assigned this right to decrease the risk of lateral movement resulting from credential theft attacks.\n\nThe Guests group must be assigned this right to prevent unauthenticated access."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000070")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220968() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        UserRightsStig1 stig = new V_220968();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
