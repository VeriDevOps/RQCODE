package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220814: The Windows Explorer Preview pane must be disabled for Windows 10.. 
 */
public class V_220814 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Group Policy\\{35378EAC-683F-11D2-A89A-00C04FBBCFA2",
            "attr", "NoGPOListChanges",
            "result_value",  "0",
            "id", "V_220814"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Group Policy\\{35378EAC-683F-11D2-A89A-00C04FBBCFA2",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Group Policy",
            "attr", "NoGPOListChanges",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220814"),
            Map.entry("title", "The Windows Explorer Preview pane must be disabled for Windows 10."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Security Option \\Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\\ must be set to \\Enabled\\ (WN10-SO-000030) for the detailed auditing subcategories to be effective.\\n\\nUse the AuditPol tool to review the current Audit Policy configuration:\\n\\nOpen a Command Prompt with elevated privileges (\\Run as Administrator\\).\\n\\nEnter \\AuditPol /get /category:*\\\\n\\nCompare the AuditPol settings with the following. If the system does not audit the following, this is a finding:\\n\\nLogon/Logoff >> Account Lockout - Failure"),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Group Policy >> \\Configure registry policy processing\\ to \\Enabled\\ and select the option \\Process even if the Group Policy objects have not changed\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Enabling this setting and then selecting the \\Process even if the Group Policy objects have not changed\\ option ensures that the policies will be reprocessed even if null have been changed. This way, any unauthorized changes are forced to match the domain-based group policy settings again."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000090")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220814() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220814();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
