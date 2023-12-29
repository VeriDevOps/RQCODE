package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220939: The system must be configured to prevent anonymous users from having the same rights as the Everyone group.. 
 */
public class V_220939 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LDAP",
            "attr", "LDAPClientIntegrity",
            "result_value",  "1",
            "id", "V_220939"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LDAP",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services",
            "attr", "LDAPClientIntegrity",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220939"),
            Map.entry("title", "The system must be configured to prevent anonymous users from having the same rights as the Everyone group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Insecure guest logons allow unauthenticated access to shared folders. Shared resources on a system must require authentication to establish proper access."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \\Network security: LDAP client signing requirements\\ to \\Negotiate signing\\ at a minimum."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","This setting controls the signing requirements for LDAP clients. This setting must be set to Negotiate signing or Require signing, depending on the environment and type of LDAP server in use."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000210")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220939() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220939();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
