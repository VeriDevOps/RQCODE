package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220792: The Remote Desktop Session Host must require secure RPC communications.. 
 */
public class V_220792 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Personalization",
            "attr", "NoLockScreenCamera",
            "result_value",  "1",
            "id", "V_220792"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Personalization",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "NoLockScreenCamera",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220792"),
            Map.entry("title", "The Remote Desktop Session Host must require secure RPC communications."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220792r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the device does not have a camera, this is NA.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\Personalization\\\n\nValue Name: NoLockScreenCamera\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22507r554861_chk"),
            Map.entry("fixtext", "If the device does not have a camera, this is NA.\n\nConfigure the policy value for Computer Configuration >> Administrative Templates >> Control Panel >> Personalization >> \"Prevent enabling lock screen camera\" to \"Enabled\"."),
            Map.entry("fixid", "F-22496r554862_fix"),
            Map.entry("description","Enabling camera access from the lock screen could allow for unauthorized use.  Requiring logon will ensure the device is only used by authorized personnel."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000005")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220792() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220792();

        //running command line interface for V_220792
        cli(stig, args);
    }

}
