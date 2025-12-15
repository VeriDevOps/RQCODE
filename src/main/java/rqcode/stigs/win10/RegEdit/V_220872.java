package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220872: Users must not be allowed to ignore Windows Defender SmartScreen filter warnings for malicious websites in Microsoft Edge.. 
 */
public class V_220872 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CloudContent",
            "attr", "DisableThirdPartySuggestions",
            "result_value",  "1",
            "id", "V_220872"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CloudContent",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "DisableThirdPartySuggestions",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220872"),
            Map.entry("title", "Users must not be allowed to ignore Windows Defender SmartScreen filter warnings for malicious websites in Microsoft Edge."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220872r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding: \n\nRegistry Hive: HKEY_CURRENT_USER\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\CloudContent\\\n\nValue Name: DisableThirdPartySuggestions\n\nType: REG_DWORD\nValue: 0x00000001 (1)\n\n"),
            Map.entry("checkid", "C-22587r555101_chk"),
            Map.entry("fixtext", "Configure the policy value for User Configuration >> Administrative Templates >> Windows Components >> Cloud Content >> \"Do not suggest third-party content in Windows spotlight\" to \"Enabled"),
            Map.entry("fixid", "F-22576r555102_fix"),
            Map.entry("description","Windows spotlight features may suggest apps and content from third-party software publishers in addition to Microsoft apps and content. "),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000390")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220872() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220872();

        //running command line interface for V_220872
        cli(stig, args);
    }

}
