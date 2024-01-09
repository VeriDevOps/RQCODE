package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220841: Camera access from the lock screen must be disabled.. 
 */
public class V_220841 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\PhishingFilter",
            "attr", "PreventOverrideAppRepUnknown",
            "result_value",  "1",
            "id", "V_220841"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\PhishingFilter",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge",
            "attr", "PreventOverrideAppRepUnknown",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220841"),
            Map.entry("title", "Camera access from the lock screen must be disabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220841r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This is applicable to unclassified systems, for other systems this is NA.\n\nWindows 10 LTSC\\B versions do not include Microsoft Edge, this is NA for those systems.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\PhishingFilter\\\n\nValue Name: PreventOverrideAppRepUnknown\n\nType: REG_DWORD\nValue: 0x00000001 (1)"),
            Map.entry("checkid", "C-22556r555008_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Microsoft Edge >> \"Prevent bypassing Windows Defender SmartScreen prompts for files\" to \"Enabled\". \n\nWindows 10 includes duplicate policies for this setting. It can also be configured under Computer Configuration >> Administrative Templates >> Windows Components >> Windows Defender SmartScreen >> Microsoft Edge."),
            Map.entry("fixid", "F-22545r555009_fix"),
            Map.entry("description","The Windows Defender SmartScreen filter in Microsoft Edge provides warning messages and blocks potentially malicious websites and file downloads.  If users are allowed to ignore warnings from the Windows Defender SmartScreen filter they could still download potentially malicious files."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000235")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220841() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220841();

        //running command line interface for V_220841
        cli(stig, args);
    }

}
