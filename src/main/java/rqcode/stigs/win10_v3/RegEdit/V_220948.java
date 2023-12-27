package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220948: User Account Control must run all administrators in Admin Approval Mode, enabling UAC.. 
 */
public class V_220948 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "attr", "EnableInstallerDetection",
            "result_value",  "1",
            "id", "V_220948"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "EnableInstallerDetection",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220948"),
            Map.entry("title", "User Account Control must run all administrators in Admin Approval Mode, enabling UAC."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This is NA as of v1803 of Windows 10; Wi-Fi sense is no longer available.\\n\\nIf the following registry value does not exist or is not configured as specified, this is a finding.\\n\\nRegistry Hive: HKEY_LOCAL_MACHINE\\nRegistry Path: \\SOFTWARE\\Microsoft\\WcmSvc\\wifinetworkmanager\\config\\\\n\\nValue Name: AutoConnectAllowedOEM\\n\\nType: REG_DWORD\\nValue: 0x00000000 (0)"),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \\User Account Control: Detect application installations and prompt for elevation\\ to \\Enabled\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","User Account Control (UAC) is a security mechanism for limiting the elevation of privileges, including administrative accounts, unless authorized. This setting requires Windows to respond to application installation requests by prompting for credentials."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000260")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220948() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220948();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
