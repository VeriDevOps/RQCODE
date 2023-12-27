package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220808: Printing over HTTP must be prevented.. 
 */
public class V_220808 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\WcmSvc\\wifinetworkmanager\\config",
            "attr", "AutoConnectAllowedOEM",
            "result_value",  "0",
            "id", "V_220808"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\WcmSvc\\wifinetworkmanager\\config",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\WcmSvc\\wifinetworkmanager",
            "attr", "AutoConnectAllowedOEM",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220808"),
            Map.entry("title", "Printing over HTTP must be prevented."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Security Option \\Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\\ must be set to \\Enabled\\ (WN10-SO-000030) for the detailed auditing subcategories to be effective.\\n\\nUse the AuditPol tool to review the current Audit Policy configuration:\\nOpen a Command Prompt with elevated privileges (\\Run as Administrator\\).\\nEnter \\AuditPol /get /category:*\\.\\n\\nCompare the AuditPol settings with the following. If the system does not audit the following, this is a finding:\\n\\nAccount Management >> User Account Management - Success"),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Network >> WLAN Service >> WLAN Settings>> \\Allow Windows to automatically connect to suggested open hotspots, to networks shared by contacts, and to hotspots offering paid services\\ to \\Disabled\\.  \\n\\nv1507 LTSB does not include this group policy setting. It may be configured through other means such as using group policy from a later version of Windows 10 or a registry update."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Wi-Fi Sense automatically connects the system to known hotspots and networks that contacts have shared. It also allows the sharing of the system's known networks to contacts. Automatically connecting to hotspots and shared networks can expose a system to unsecured or potentially malicious systems."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000065")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220808() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220808();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
