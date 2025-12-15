package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220944: Outgoing secure channel traffic must be signed when possible.. 
 */
public class V_220944 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "attr", "FilterAdministratorToken",
            "result_value",  "1",
            "id", "V_220944"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "FilterAdministratorToken",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220944"),
            Map.entry("title", "Outgoing secure channel traffic must be signed when possible."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220944r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\\n\nValue Name: FilterAdministratorToken\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22659r555317_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"User Account Control: Admin Approval Mode for the Built-in Administrator account\" to \"Enabled\"."),
            Map.entry("fixid", "F-22648r555318_fix"),
            Map.entry("description","User Account Control (UAC) is a security mechanism for limiting the elevation of privileges, including administrative accounts, unless authorized.  This setting configures the built-in Administrator account so that it runs in Admin Approval Mode."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000245")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220944() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220944();

        //running command line interface for V_220944
        cli(stig, args);
    }

}
