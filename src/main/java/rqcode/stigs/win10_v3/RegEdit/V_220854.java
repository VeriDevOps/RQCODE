package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220854: File Explorer shell protocol must run in protected mode.. 
 */
public class V_220854 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Internet Explorer\\Feeds",
            "attr", "AllowBasicAuthInClear",
            "result_value",  "0",
            "id", "V_220854"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Internet Explorer\\Feeds",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Internet Explorer",
            "attr", "AllowBasicAuthInClear",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220854"),
            Map.entry("title", "File Explorer shell protocol must run in protected mode."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220854r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "The default behavior is for the Windows RSS platform to not use Basic authentication over HTTP connections.\n\nIf the registry value name below does not exist, this is not a finding.\n\nIf it exists and is configured with a value of \"0\", this is not a finding.\n\nIf it exists and is configured with a value of \"1\", this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Internet Explorer\\Feeds\\\n\nValue Name: AllowBasicAuthInClear\n\nValue Type: REG_DWORD\nValue: 0 (or if the Value Name does not exist)"),
            Map.entry("checkid", "C-22569r555047_chk"),
            Map.entry("fixtext", "The default behavior is for the Windows RSS platform to not use Basic authentication over HTTP connections.\n\nIf this needs to be corrected, configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> RSS Feeds >> \"Turn on Basic feed authentication over HTTP\" to \"Not Configured\" or \"Disabled\"."),
            Map.entry("fixid", "F-22558r555048_fix"),
            Map.entry("description","Basic authentication uses plain text passwords that could be used to compromise a system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000300")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220854() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220854();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
