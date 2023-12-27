package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220858: Outgoing secure channel traffic must be encrypted when possible.. 
 */
public class V_220858 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer",
            "attr", "SafeForScripting",
            "result_value",  "0",
            "id", "V_220858"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "SafeForScripting",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220858"),
            Map.entry("title", "Outgoing secure channel traffic must be encrypted when possible."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Security Option \\Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\\ must be set to \\Enabled\\ (WN10-SO-000030) for the detailed auditing subcategories to be effective.\\n\\nUse the AuditPol tool to review the current Audit Policy configuration:\\nOpen a Command Prompt with elevated privileges (\\Run as Administrator\\).\\nEnter \\AuditPol /get /category:*\\.\\n\\nCompare the AuditPol settings with the following. If the system does not audit the following, this is a finding:\\n\\nSystem >> System Integrity - Failure"),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "The default behavior is for Internet Explorer to warn users and select whether to allow or refuse installation when a web-based program attempts to install software on the system.\\n\\nIf this needs to be corrected, configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Installer >> \\Prevent Internet Explorer security prompt for Windows Installer scripts\\ to \\Not Configured\\ or \\Disabled\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Web-based programs may attempt to install malicious software on a system. Ensuring users are notified if a web-based program attempts to install software allows them to refuse the installation."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000320")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220858() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220858();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
