package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220834: Windows Telemetry must not be configured to Full.
 *
 * NOTE: the STIG accepts AllowTelemetry values 0 (Security) or 1 (Basic), and conditionally 2 (Enhanced) when V_220833 is also configured. This class checks for 0, the most restrictive compliant value.
 */
public class V_220834 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DataCollection",
            "attr", "AllowTelemetry",
            "result_value",  "0",
            "id", "V_220834"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DataCollection",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "AllowTelemetry",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220834"),
            Map.entry("title", "Windows Telemetry must not be configured to Full."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220834r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\DataCollection\\\n\nValue Name: AllowTelemetry\n\nType: REG_DWORD\nValue: 0x00000000 (0) (Security)\n0x00000001 (1) (Basic)\n\nIf an organization is using v1709 or later of Windows 10 this may be configured to \"Enhanced\" to support Windows Analytics. V-82145 must also be configured to limit the Enhanced diagnostic data to the minimum required by Windows Analytics. This registry value will then be 0x00000002 (2)."),
            Map.entry("checkid", "C-22549r554987_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Data Collection and Preview Builds >> \"Allow Telemetry\" to \"Enabled\" with \"0 - Security [Enterprise Only]\" or \"1 - Basic\" selected in \"Options:\".   \n\nIf an organization is using v1709 or later of Windows 10 this may be configured to \"2 - Enhanced\" to support Windows Analytics. V-82145 must also be configured to limit the Enhanced diagnostic data to the minimum required by Windows Analytics."),
            Map.entry("fixid", "F-22538r554988_fix"),
            Map.entry("description", "Some features may communicate with the vendor, sending system information or downloading data or components for the feature. Limiting this capability will prevent potentially sensitive information from being sent outside the enterprise. The \"Security\" option for Telemetry configures the lowest amount of data, effectively none outside of the Malicious Software Removal Tool (MSRT), Defender and telemetry client settings. \"Basic\" sends basic diagnostic and usage data and may be required to support some Microsoft services. \"Enhanced\" includes additional information on how Windows and apps are used and advanced reliability data. Windows Analytics can use a \"limited enhanced\" level to provide information such as health data for devices.  This requires the configuration of an additional setting available with v1709 and later of Windows 10. "),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000205")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220834() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220834();

        //running command line interface for V_220834
        cli(stig, args);
    }

}
