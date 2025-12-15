package rqcode.stigs.win10.UserRights;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

import rqcode.stigs.STIG;

/**
 * V_220957: The Access Credential Manager as a trusted caller user right must not be assigned to any groups or accounts.. 
 */
public class V_220957 extends UserRightsStig5 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeNetworkLogonRight"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeNetworkLogonRight"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220957"),
            Map.entry("title", "The Access Credential Manager as a trusted caller user right must not be assigned to any groups or accounts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220957r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\nRun \"gpedit.msc\".\n\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n\nIf any groups or accounts other than the following are granted the \"Access this computer from the network\" user right, this is a finding:\n\nAdministrators\nRemote Desktop Users\n\nIf a domain application account such as for a management tool requires this user right, this would not be a finding.\n\nVendor documentation must support the requirement for having the user right.\n\nThe requirement must be documented with the ISSO.\n\nThe application account, managed at the domain level, must meet requirements for application account passwords, such as length and frequency of changes as defined in the Windows server STIGs."),
            Map.entry("checkid", "C-22671r555353_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"Access this computer from the network\" to only include the following groups or accounts:\n\nAdministrators   \nRemote Desktop Users"),
            Map.entry("fixid", "F-22661r555357_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Access this computer from the network\" user right may access resources on the system, and must be limited to those that require it."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000010")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220957() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        STIG stig = new V_220957();

        //running command line interface for V_220957
        cli(stig, args);
    }

}
