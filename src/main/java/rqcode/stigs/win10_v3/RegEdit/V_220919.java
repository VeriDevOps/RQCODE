package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220919: Users must be prompted for a password on resume from sleep (on battery).. 
 */
public class V_220919 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "attr", "RequireStrongKey",
            "result_value",  "1",
            "id", "V_220919"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon",
            "attr", "RequireStrongKey",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220919"),
            Map.entry("title", "Users must be prompted for a password on resume from sleep (on battery)."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220919r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters\\\n\nValue Name: RequireStrongKey\n\nValue Type: REG_DWORD\nValue: 1\n \nWarning: This setting may prevent a system from being joined to a domain if not configured consistently between systems."),
            Map.entry("checkid", "C-22634r555242_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Domain member: Require strong (Windows 2000 or Later) session key\" to \"Enabled\"."),
            Map.entry("fixid", "F-22623r555243_fix"),
            Map.entry("description","A computer connecting to a domain controller will establish a secure channel.  Requiring strong session keys enforces 128-bit encryption between systems."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000060")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220919() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220919();

        //running command line interface for V_220919
        cli(stig, args);
    }

}
