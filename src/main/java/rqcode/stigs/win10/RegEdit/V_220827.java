package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220827: Toast notifications to the lock screen must be turned off.. 
 */
public class V_220827 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer",
            "attr", "NoAutoplayfornonVolume",
            "result_value",  "1",
            "id", "V_220827"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "NoAutoplayfornonVolume",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220827"),
            Map.entry("title", "Toast notifications to the lock screen must be turned off."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220827r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer\\\n\nValue Name: NoAutoplayfornonVolume\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22542r554966_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> AutoPlay Policies >> \"Disallow Autoplay for non-volume devices\" to \"Enabled\"."),
            Map.entry("fixid", "F-22531r554967_fix"),
            Map.entry("description","Allowing autoplay to execute may introduce malicious code to a system.  Autoplay begins reading from a drive as soon as you insert media in the drive.  As a result, the setup file of programs or music on audio media may start.  This setting will disable autoplay for non-volume devices (such as Media Transfer Protocol (MTP) devices)."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000180")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220827() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220827();

        //running command line interface for V_220827
        cli(stig, args);
    }

}
