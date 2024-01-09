package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220870: Windows 10 must be configured to require a minimum pin length of six characters or greater.. 
 */
public class V_220870 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\System",
            "attr", "AllowDomainPINLogon",
            "result_value",  "0",
            "id", "V_220870"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\System",
            "path_short", "HKLM:\\Software\\Policies\\Microsoft\\Windows",
            "attr", "AllowDomainPINLogon",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220870"),
            Map.entry("title", "Windows 10 must be configured to require a minimum pin length of six characters or greater."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220870r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\Software\\Policies\\Microsoft\\Windows\\System\n\nValue Name: AllowDomainPINLogon\nValue Type: REG_DWORD\nValue data: 0"),
            Map.entry("checkid", "C-22585r555095_chk"),
            Map.entry("fixtext", "Disable the convenience PIN sign-in. \n\nIf this needs to be corrected configure the policy value for Computer Configuration >> Administrative Templates >> System >> Logon >> Set \"Turn on convenience PIN sign-in\" to \"Disabled\u201d.\n"),
            Map.entry("fixid", "F-22574r555096_fix"),
            Map.entry("description","This policy controls whether a domain user can sign in using a convenience PIN to prevent enabling (Password Stuffer)."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000370")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220870() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220870();

        //running command line interface for V_220870
        cli(stig, args);
    }

}
