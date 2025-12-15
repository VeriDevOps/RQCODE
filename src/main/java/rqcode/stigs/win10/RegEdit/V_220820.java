package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220820: NTLM must be prevented from falling back to a Null session.. 
 */
public class V_220820 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\System",
            "attr", "EnumerateLocalUsers",
            "result_value",  "0",
            "id", "V_220820"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\System",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "EnumerateLocalUsers",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220820"),
            Map.entry("title", "NTLM must be prevented from falling back to a Null session."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220820r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\System\\\n\nValue Name: EnumerateLocalUsers\n\nValue Type: REG_DWORD\nValue: 0"),
            Map.entry("checkid", "C-22535r554945_chk"),
            Map.entry("fixtext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\n\nConfigure the policy value for Computer Configuration >> Administrative Templates >> System >> Logon >> \"Enumerate local users on domain-joined computers\" to \"Disabled\"."),
            Map.entry("fixid", "F-22524r554946_fix"),
            Map.entry("description","The username is one part of logon credentials that could be used to gain access to a system.  Preventing the enumeration of users limits this information to authorized personnel."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000130")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220820() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220820();

        //running command line interface for V_220820
        cli(stig, args);
    }

}
