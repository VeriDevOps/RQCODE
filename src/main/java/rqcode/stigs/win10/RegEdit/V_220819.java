package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220819: The Windows Defender SmartScreen filter for Microsoft Edge must be enabled.. 
 */
public class V_220819 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\System",
            "attr", "DontDisplayNetworkSelectionUI",
            "result_value",  "1",
            "id", "V_220819"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\System",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "DontDisplayNetworkSelectionUI",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220819"),
            Map.entry("title", "The Windows Defender SmartScreen filter for Microsoft Edge must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220819r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\System\\\n\nValue Name: DontDisplayNetworkSelectionUI\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22534r554942_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Logon >> \"Do not display network selection UI\" to \"Enabled\"."),
            Map.entry("fixid", "F-22523r554943_fix"),
            Map.entry("description","Enabling interaction with the network selection UI allows users to change connections to available networks without signing into Windows."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000120")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220819() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220819();

        //running command line interface for V_220819
        cli(stig, args);
    }

}
