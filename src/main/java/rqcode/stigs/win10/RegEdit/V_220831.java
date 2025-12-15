package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220831: Microsoft consumer experiences must be turned off.. 
 */
public class V_220831 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CloudContent",
            "attr", "DisableWindowsConsumerFeatures",
            "result_value",  "1",
            "id", "V_220831"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CloudContent",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "DisableWindowsConsumerFeatures",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220831"),
            Map.entry("title", "Microsoft consumer experiences must be turned off."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220831r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "Windows 10 v1507 LTSB version does not include this setting; it is NA for those systems.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\CloudContent\\\n\nValue Name: DisableWindowsConsumerFeatures\n\nType: REG_DWORD\nValue: 0x00000001 (1)"),
            Map.entry("checkid", "C-22546r554978_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Cloud Content >> \"Turn off Microsoft consumer experiences\" to \"Enabled\"."),
            Map.entry("fixid", "F-22535r554979_fix"),
            Map.entry("description","Microsoft consumer experiences provides suggestions and notifications to users, which may include the installation of Windows Store apps.  Organizations may control the execution of applications through other means such as whitelisting.  Turning off Microsoft consumer experiences will help prevent the unwanted installation of suggested applications."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000197")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220831() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220831();

        //running command line interface for V_220831
        cli(stig, args);
    }

}
