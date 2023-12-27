package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220852: The Security event log size must be configured to 1024000 KB or greater.. 
 */
public class V_220852 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "attr", "MinEncryptionLevel",
            "result_value",  "3",
            "id", "V_220852"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT",
            "attr", "MinEncryptionLevel",
            "result_value", "3"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220852"),
            Map.entry("title", "The Security event log size must be configured to 1024000 KB or greater."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Security Option \\Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\\ must be set to \\Enabled\\ (WN10-SO-000030) for the detailed auditing subcategories to be effective. \\n\\nUse the AuditPol tool to review the current Audit Policy configuration:\\nOpen a Command Prompt with elevated privileges (\\Run as Administrator\\).\\nEnter \\AuditPol /get /category:*\\\\n\\nCompare the AuditPol settings with the following. If the system does not audit the following, this is a finding:\\n\\nSystem >> Other System Events - Failure"),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Remote Desktop Services >> Remote Desktop Session Host >> Security >> \\Set client connection encryption level\\ to \\Enabled\\ and \\High Level\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Remote connections must be encrypted to prevent interception of data or sensitive information. Selecting \\High Level\\ will ensure encryption of Remote Desktop Services sessions in both directions."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000290")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220852() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220852();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
