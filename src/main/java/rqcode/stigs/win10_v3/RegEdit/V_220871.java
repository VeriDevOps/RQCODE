package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220871: The use of a hardware security device with Windows Hello for Business must be enabled.. 
 */
public class V_220871 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\Software\\Policies\\Microsoft\\WindowsInkWorkspace",
            "attr", "AllowWindowsInkWorkspace",
            "result_value",  "1",
            "id", "V_220871"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\Software\\Policies\\Microsoft\\WindowsInkWorkspace",
            "path_short", "HKLM:\\Software\\Policies\\Microsoft",
            "attr", "AllowWindowsInkWorkspace",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220871"),
            Map.entry("title", "The use of a hardware security device with Windows Hello for Business must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220871r642141_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\Software\\Policies\\Microsoft\\WindowsInkWorkspace\n\nValue Name: AllowWindowsInkWorkspace\nValue Type: REG_DWORD\nValue data: 1"),
            Map.entry("checkid", "C-22586r642139_chk"),
            Map.entry("fixtext", "Disable the convenience PIN sign-in. \n\nIf this needs to be corrected, configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Ink Workspace >> Set \"Allow Windows Ink Workspace\" to \"Enabled\u201d and set Options \"On, but disallow access above lock\"."),
            Map.entry("fixid", "F-22575r642140_fix"),
            Map.entry("description","This action secures Windows Ink, which contains applications and features oriented toward pen computing."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000385")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220871() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220871();

        //running command line interface for V_220871
        cli(stig, args);
    }

}
