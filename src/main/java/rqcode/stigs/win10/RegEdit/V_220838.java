package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220838: Turning off File Explorer heap termination on corruption must be disabled.
 */
public class V_220838 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer",
            "attr", "NoHeapTerminationOnCorruption",
            "result_value",  "0",
            "id", "V_220838"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "NoHeapTerminationOnCorruption",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220838"),
            Map.entry("title", "Turning off File Explorer heap termination on corruption must be disabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220838r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "The default behavior is for File Explorer heap termination on corruption to be enabled.\n\nIf the registry Value Name below does not exist, this is not a finding.\n\nIf it exists and is configured with a value of \"0\", this is not a finding.\n\nIf it exists and is configured with a value of \"1\", this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\Explorer\\\n\nValue Name: NoHeapTerminationOnCorruption\n\nValue Type: REG_DWORD\nValue: 0x00000000 (0) (or if the Value Name does not exist)"),
            Map.entry("checkid", "C-22553r554999_chk"),
            Map.entry("fixtext", "The default behavior is for File Explorer heap termination on corruption to be enabled.\n\nIf this needs to be corrected, configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> File Explorer >> \"Turn off heap termination on corruption\" to \"Not Configured\" or \"Disabled\"."),
            Map.entry("fixid", "F-22542r555000_fix"),
            Map.entry("description", "Legacy plug-in applications may continue to function when a File Explorer session has become corrupt.  Disabling this feature will prevent this."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000220")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220838() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220838();

        //running command line interface for V_220838
        cli(stig, args);
    }

}
