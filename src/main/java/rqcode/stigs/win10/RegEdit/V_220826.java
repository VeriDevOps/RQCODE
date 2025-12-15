package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220826: The Server Message Block (SMB) v1 protocol must be disabled on the SMB server.. 
 */
public class V_220826 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\AppCompat",
            "attr", "DisableInventory",
            "result_value",  "1",
            "id", "V_220826"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\AppCompat",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "DisableInventory",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220826"),
            Map.entry("title", "The Server Message Block (SMB) v1 protocol must be disabled on the SMB server."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220826r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\AppCompat\\\n\nValue Name: DisableInventory\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22541r554963_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Application Compatibility >> \"Turn off Inventory Collector\" to \"Enabled\"."),
            Map.entry("fixid", "F-22530r554964_fix"),
            Map.entry("description","Some features may communicate with the vendor, sending system information or downloading data or components for the feature.  Turning off this capability will prevent potentially sensitive information from being sent outside the enterprise and uncontrolled updates to the system.  This setting will prevent the Program Inventory from collecting data about a system and sending the information to Microsoft."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000175")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220826() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220826();

        //running command line interface for V_220826
        cli(stig, args);
    }

}
