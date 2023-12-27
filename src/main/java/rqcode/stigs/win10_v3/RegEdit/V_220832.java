package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220832: Users must not be allowed to ignore Windows Defender SmartScreen filter warnings for unverified files in Microsoft Edge.. 
 */
public class V_220832 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\CredUI",
            "attr", "EnumerateAdministrators",
            "result_value",  "0",
            "id", "V_220832"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\CredUI",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "EnumerateAdministrators",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220832"),
            Map.entry("title", "Users must not be allowed to ignore Windows Defender SmartScreen filter warnings for unverified files in Microsoft Edge."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Security Option \\Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\\ must be set to \\Enabled\\ (WN10-SO-000030) for the detailed auditing subcategories to be effective.\\n\\nUse the AuditPol tool to review the current Audit Policy configuration:\\n\\nOpen PowerShell or a Command Prompt with elevated privileges (\\Run as Administrator\\).\\n\\nEnter \\AuditPol /get /category:*\\\\n\\nCompare the AuditPol settings with the following:\\n\\nObject Access >> Other Object Access Events - Failure\\n\\nIf the system does not audit the above, this is a finding."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Credential User Interface >> \\Enumerate administrator accounts on elevation\\ to \\Disabled\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Enumeration of administrator accounts when elevating can provide part of the logon information to an unauthorized user. This setting configures the system to always require users to type in a username and password to elevate a running application."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000200")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220832() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220832();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
