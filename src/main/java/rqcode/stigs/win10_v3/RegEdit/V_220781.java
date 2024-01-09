package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220781: The setting to allow Microsoft accounts to be optional for modern style apps must be enabled.. 
 */
public class V_220781 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\System",
            "attr", "MaxSize",
            "result_value",  "32768",
            "id", "V_220781"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\System",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog",
            "attr", "MaxSize",
            "result_value", "32768"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220781"),
            Map.entry("title", "The setting to allow Microsoft accounts to be optional for modern style apps must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220781r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the system is configured to send audit records directly to an audit server, this is NA.  This must be documented with the ISSO.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive:  HKEY_LOCAL_MACHINE\nRegistry Path:  \\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\System\\\n\nValue Name:  MaxSize\n\nValue Type:  REG_DWORD\nValue:  0x00008000 (32768) (or greater)"),
            Map.entry("checkid", "C-22496r554828_chk"),
            Map.entry("fixtext", "If the system is configured to send audit records directly to an audit server, this is NA.  This must be documented with the ISSO.\n\nConfigure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Event Log Service >> System >> \"Specify the maximum log file size (KB)\" to \"Enabled\" with a \"Maximum Log Size (KB)\" of \"32768\" or greater."),
            Map.entry("fixid", "F-22485r554829_fix"),
            Map.entry("description","Inadequate log size will cause the log to fill up quickly.  This may prevent audit events from being recorded properly and require frequent attention by administrative personnel."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-AU-000510")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220781() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220781();

        //running command line interface for V_220781
        cli(stig, args);
    }

}
