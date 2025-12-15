package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220850: The default autorun behavior must be configured to prevent autorun commands.. 
 */
public class V_220850 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "attr", "fPromptForPassword",
            "result_value",  "1",
            "id", "V_220850"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT",
            "attr", "fPromptForPassword",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220850"),
            Map.entry("title", "The default autorun behavior must be configured to prevent autorun commands."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220850r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services\\\n\nValue Name: fPromptForPassword\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22565r555035_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Remote Desktop Services >> Remote Desktop Session Host >> Security >> \"Always prompt for password upon connection\" to \"Enabled\"."),
            Map.entry("fixid", "F-22554r555036_fix"),
            Map.entry("description","This setting controls the ability of users to supply passwords automatically as part of their remote desktop connection.  Disabling this setting would allow anyone to use the stored credentials in a connection item to connect to the terminal server."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000280")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220850() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220850();

        //running command line interface for V_220850
        cli(stig, args);
    }

}
