package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220839: Unauthenticated RPC clients must be restricted from connecting to the RPC server.. 
 */
public class V_220839 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer",
            "attr", "PreXPSP2ShellProtocolBehavior",
            "result_value",  "0",
            "id", "V_220839"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "PreXPSP2ShellProtocolBehavior",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220839"),
            Map.entry("title", "Unauthenticated RPC clients must be restricted from connecting to the RPC server."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220839r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "The default behavior is for shell protected mode to be turned on for file explorer.\n\nIf the registry value name below does not exist, this is not a finding.\n\nIf it exists and is configured with a value of \"0\", this is not a finding.\n\nIf it exists and is configured with a value of \"1\", this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\\n\nValue Name: PreXPSP2ShellProtocolBehavior\n\nValue Type: REG_DWORD\nValue: 0 (or if the Value Name does not exist)"),
            Map.entry("checkid", "C-22554r555002_chk"),
            Map.entry("fixtext", "The default behavior is for shell protected mode to be turned on for file explorer.\n\nIf this needs to be corrected, configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> File Explorer >> \"Turn off shell protocol protected mode\" to \"Not Configured\" or \"Disabled\"."),
            Map.entry("fixid", "F-22543r555003_fix"),
            Map.entry("description","The shell protocol will  limit the set of folders applications can open when run in protected mode.  Restricting files an application can open, to a limited set of folders, increases the security of Windows."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000225")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220839() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220839();

        //running command line interface for V_220839
        cli(stig, args);
    }

}
