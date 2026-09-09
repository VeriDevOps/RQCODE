package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220837: Explorer Data Execution Prevention must be enabled.
 */
public class V_220837 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer",
            "attr", "NoDataExecutionPrevention",
            "result_value",  "0",
            "id", "V_220837"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "NoDataExecutionPrevention",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220837"),
            Map.entry("title", "Explorer Data Execution Prevention must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220837r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "The default behavior is for data execution prevention to be turned on for file explorer.\n\nIf the registry value name below does not exist, this is not a finding.\n\nIf it exists and is configured with a value of \"0\", this is not a finding.\n\nIf it exists and is configured with a value of \"1\", this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer\\\n\nValue Name: NoDataExecutionPrevention\n\nValue Type: REG_DWORD\nValue: 0 (or if the Value Name does not exist)"),
            Map.entry("checkid", "C-22552r554996_chk"),
            Map.entry("fixtext", "The default behavior is for data execution prevention to be turned on for file explorer.\n\nIf this needs to be corrected, configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> File Explorer >> \"Turn off Data Execution Prevention for Explorer\" to \"Not Configured\" or \"Disabled\"."),
            Map.entry("fixid", "F-22541r554997_fix"),
            Map.entry("description", "Data Execution Prevention (DEP) provides additional protection by performing  checks on memory to help prevent malicious code from running.  This setting will prevent Data Execution Prevention from being turned off for File Explorer."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000215")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220837() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220837();

        //running command line interface for V_220837
        cli(stig, args);
    }

}
