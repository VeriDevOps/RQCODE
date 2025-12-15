package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220860: User Account Control must virtualize file and registry write failures to per-user locations.. 
 */
public class V_220860 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell\\ScriptBlockLogging",
            "attr", "EnableScriptBlockLogging",
            "result_value",  "1",
            "id", "V_220860"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell\\ScriptBlockLogging",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell",
            "attr", "EnableScriptBlockLogging",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220860"),
            Map.entry("title", "User Account Control must virtualize file and registry write failures to per-user locations."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220860r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE \nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\PowerShell\\ScriptBlockLogging\\\n\nValue Name: EnableScriptBlockLogging\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22575r555065_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows PowerShell >> \"Turn on PowerShell Script Block Logging\" to \"Enabled\"."),
            Map.entry("fixid", "F-22564r555066_fix"),
            Map.entry("description","Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\n\nEnabling PowerShell script block logging will record detailed information from the processing of PowerShell commands and scripts.  This can provide additional detail when malware has run on a system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000326")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220860() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220860();

        //running command line interface for V_220860
        cli(stig, args);
    }

}
