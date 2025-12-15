package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220945: Zone information must be preserved when saving attachments.. 
 */
public class V_220945 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "attr", "ConsentPromptBehaviorAdmin",
            "result_value",  "2",
            "id", "V_220945"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "ConsentPromptBehaviorAdmin",
            "result_value", "2"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220945"),
            Map.entry("title", "Zone information must be preserved when saving attachments."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220945r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\\n\nValue Name: ConsentPromptBehaviorAdmin\n\nValue Type: REG_DWORD\nValue: 2 (Prompt for consent on the secure desktop)"),
            Map.entry("checkid", "C-22660r555320_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"User Account Control: Behavior of the elevation prompt for administrators in Admin Approval Mode\" to \"Prompt for consent on the secure desktop\"."),
            Map.entry("fixid", "F-22649r555321_fix"),
            Map.entry("description","User Account Control (UAC) is a security mechanism for limiting the elevation of privileges, including administrative accounts, unless authorized.  This setting configures the elevation requirements for logged on administrators to complete a task that requires raised privileges."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000250")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220945() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220945();

        //running command line interface for V_220945
        cli(stig, args);
    }

}
