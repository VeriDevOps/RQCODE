package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220951: The system must be configured to meet the minimum session security requirement for NTLM SSP based clients.. 
 */
public class V_220951 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "attr", "EnableVirtualization",
            "result_value",  "1",
            "id", "V_220951"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "EnableVirtualization",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220951"),
            Map.entry("title", "The system must be configured to meet the minimum session security requirement for NTLM SSP based clients."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220951r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\\n\nValue Name: EnableVirtualization\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22666r555338_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"User Account Control: Virtualize file and registry write failures to per-user locations\" to \"Enabled\"."),
            Map.entry("fixid", "F-22655r555339_fix"),
            Map.entry("description","User Account Control (UAC) is a security mechanism for limiting the elevation of privileges, including administrative accounts, unless authorized.  This setting configures non-UAC compliant applications to run in virtualized file and registry entries in per-user locations, allowing them to run."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000275")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220951() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220951();

        //running command line interface for V_220951
        cli(stig, args);
    }

}
