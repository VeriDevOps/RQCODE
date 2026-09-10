package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220833: If Enhanced diagnostic data is enabled it must be limited to the minimum required to support Windows Analytics.
 */
public class V_220833 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DataCollection",
            "attr", "LimitEnhancedDiagnosticDataWindowsAnalytics",
            "result_value",  "1",
            "id", "V_220833"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DataCollection",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "LimitEnhancedDiagnosticDataWindowsAnalytics",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220833"),
            Map.entry("title", "If Enhanced diagnostic data is enabled it must be limited to the minimum required to support Windows Analytics."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220833r793250_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This setting requires v1709 or later of Windows 10; it is NA for prior versions.\n\nIf \"Enhanced\" level is enabled for telemetry, this must be configured. If \"Security\" or \"Basic\" are configured, this is NA. (See V-220834).\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\DataCollection\\\n\nValue Name: LimitEnhancedDiagnosticDataWindowsAnalytics\n\nType: REG_DWORD\nValue: 0x00000001 (1)"),
            Map.entry("checkid", "C-22548r793249_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Data Collection and Preview Builds >> \"Limit Enhanced diagnostic data to the minimum required by Windows Analytics\" to \"Enabled\" with \"Enable Windows Analytics collection\" selected in \"Options:\"."),
            Map.entry("fixid", "F-22537r554985_fix"),
            Map.entry("description", "Some features may communicate with the vendor, sending system information or downloading data or components for the feature. Limiting this capability will prevent potentially sensitive information from being sent outside the enterprise. The \"Enhanced\" level for telemetry includes additional information beyond \"Security\" and \"Basic\" on how Windows and apps are used and advanced reliability data. Windows Analytics can use a \"limited enhanced\" level to provide information such as health data for devices."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000204")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220833() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220833();

        //running command line interface for V_220833
        cli(stig, args);
    }

}
