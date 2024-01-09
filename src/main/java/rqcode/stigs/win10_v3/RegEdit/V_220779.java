package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220779: The system must be configured to prevent the storage of the LAN Manager hash of passwords.. 
 */
public class V_220779 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\Application",
            "attr", "MaxSize",
            "result_value",  "32768",
            "id", "V_220779"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\Application",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog",
            "attr", "MaxSize",
            "result_value", "32768"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220779"),
            Map.entry("title", "The system must be configured to prevent the storage of the LAN Manager hash of passwords."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220779r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the system is configured to send audit records directly to an audit server, this is NA.  This must be documented with the ISSO.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive:  HKEY_LOCAL_MACHINE\nRegistry Path:  \\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\Application\\\n\nValue Name:  MaxSize\n\nValue Type:  REG_DWORD\nValue:  0x00008000 (32768) (or greater)"),
            Map.entry("checkid", "C-22494r554822_chk"),
            Map.entry("fixtext", "If the system is configured to send audit records directly to an audit server, this is NA.  This must be documented with the ISSO.\n\nConfigure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Event Log Service >> Application >> \"Specify the maximum log file size (KB)\" to \"Enabled\" with a \"Maximum Log Size (KB)\" of \"32768\" or greater."),
            Map.entry("fixid", "F-22483r554823_fix"),
            Map.entry("description","Inadequate log size will cause the log to fill up quickly.  This may prevent audit events from being recorded properly and require frequent attention by administrative personnel."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-AU-000500")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220779() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220779();

        //running command line interface for V_220779
        cli(stig, args);
    }

}
