package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220822: The LanMan authentication level must be set to send NTLMv2 response only, and to refuse LM and NTLM.. 
 */
public class V_220822 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings\\0e796bdb-100d-47d6-a2d5-f7d2daa51f51",
            "attr", "ACSettingIndex",
            "result_value",  "1",
            "id", "V_220822"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings\\0e796bdb-100d-47d6-a2d5-f7d2daa51f51",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings",
            "attr", "ACSettingIndex",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220822"),
            Map.entry("title", "The LanMan authentication level must be set to send NTLMv2 response only, and to refuse LM and NTLM."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220822r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings\\0e796bdb-100d-47d6-a2d5-f7d2daa51f51\\\n\nValue Name: ACSettingIndex\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22537r554951_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Power Management >> Sleep Settings >> \"Require a password when a computer wakes (plugged in)\" to \"Enabled\"."),
            Map.entry("fixid", "F-22526r554952_fix"),
            Map.entry("description","Authentication must always be required when accessing a system.  This setting ensures the user is prompted for a password on resume from sleep (plugged in)."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000150")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220822() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220822();

        //running command line interface for V_220822
        cli(stig, args);
    }

}
