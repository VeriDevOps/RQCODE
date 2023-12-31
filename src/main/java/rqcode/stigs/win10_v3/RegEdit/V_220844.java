package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220844: Local administrator accounts must have their privileged token filtered to prevent elevated privileges from being used over the network on domain systems.. 
 */
public class V_220844 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\PhishingFilter",
            "attr", "EnabledV9",
            "result_value",  "1",
            "id", "V_220844"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\PhishingFilter",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge",
            "attr", "EnabledV9",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220844"),
            Map.entry("title", "Local administrator accounts must have their privileged token filtered to prevent elevated privileges from being used over the network on domain systems."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220844r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This is applicable to unclassified systems, for other systems this is NA.\n\nWindows 10 LTSC\\B versions do not include Microsoft Edge, this is NA for those systems.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\PhishingFilter\\\n\nValue Name: EnabledV9\n\nType: REG_DWORD\nValue: 0x00000001 (1)"),
            Map.entry("checkid", "C-22559r555017_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Microsoft Edge >> \"Configure Windows Defender SmartScreen\" to \"Enabled\". \n\nWindows 10 includes duplicate policies for this setting. It can also be configured under Computer Configuration >> Administrative Templates >> Windows Components >> Windows Defender SmartScreen >> Microsoft Edge."),
            Map.entry("fixid", "F-22548r555018_fix"),
            Map.entry("description","The Windows Defender SmartScreen filter in Microsoft Edge provides warning messages and blocks potentially malicious websites."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000250")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220844() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220844();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
