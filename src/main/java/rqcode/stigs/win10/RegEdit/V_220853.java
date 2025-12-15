package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220853: The System event log size must be configured to 32768 KB or greater.. 
 */
public class V_220853 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Internet Explorer\\Feeds",
            "attr", "DisableEnclosureDownload",
            "result_value",  "1",
            "id", "V_220853"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Internet Explorer\\Feeds",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Internet Explorer",
            "attr", "DisableEnclosureDownload",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220853"),
            Map.entry("title", "The System event log size must be configured to 32768 KB or greater."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220853r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Internet Explorer\\Feeds\\\n\nValue Name: DisableEnclosureDownload\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22568r555044_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> RSS Feeds >> \"Prevent downloading of enclosures\" to \"Enabled\"."),
            Map.entry("fixid", "F-22557r555045_fix"),
            Map.entry("description","Attachments from RSS feeds may not be secure.  This setting will prevent attachments from being downloaded from RSS feeds."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000295")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220853() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220853();

        //running command line interface for V_220853
        cli(stig, args);
    }

}
