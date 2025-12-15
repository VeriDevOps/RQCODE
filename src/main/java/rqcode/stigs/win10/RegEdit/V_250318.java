package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_250318: Administrator accounts must not be enumerated during elevation.. 
 */
public class V_250318 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell\\Transcription",
            "attr", "EnableTranscripting",
            "result_value",  "1",
            "id", "V_250318"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell\\Transcription",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell",
            "attr", "EnableTranscripting",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_250318"),
            Map.entry("title", "Administrator accounts must not be enumerated during elevation."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_250318r793287_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell\\Transcription\\\n\nValue Name: EnableTranscripting\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-53753r793285_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows PowerShell >> \"Turn on PowerShell Transcription\" to \"Enabled\".\n\nSpecify the Transcript output directory to point to a Central Log Server or another secure location to prevent user access."),
            Map.entry("fixid", "F-53707r793286_fix"),
            Map.entry("description","Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\n\nEnabling PowerShell Transcription will record detailed information from the processing of PowerShell commands and scripts. This can provide additional detail when malware has run on a system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000327")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_250318() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_250318();

        //running command line interface for V_250318
        cli(stig, args);
    }

}
