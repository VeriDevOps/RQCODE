package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220843: The password manager function in the Edge browser must be disabled.
 */
public class V_220843 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Main",
            "attr", "FormSuggest Passwords",
            "result_value",  "no",
            "id", "V_220843"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Main",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge",
            "attr", "FormSuggest Passwords",
            "result_value", "no"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220843"),
            Map.entry("title", "The password manager function in the Edge browser must be disabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220843r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Windows 10 LTSC\\B versions do not include Microsoft Edge, this is NA for those systems.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Main\\\n\nValue Name: FormSuggest Passwords\n\nType: REG_SZ\nValue: no"),
            Map.entry("checkid", "C-22558r555014_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Microsoft Edge >> \"Configure Password Manager\" to \"Disabled\"."),
            Map.entry("fixid", "F-22547r555015_fix"),
            Map.entry("description", "Passwords save locally for re-use when browsing may be subject to compromise.  Disabling the Edge password manager will prevent this for the browser."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000245")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220843() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220843();

        //running command line interface for V_220843
        cli(stig, args);
    }

}
