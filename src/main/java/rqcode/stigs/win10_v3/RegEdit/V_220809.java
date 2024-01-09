package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220809: Web publishing and online ordering wizards must be prevented from downloading a list of providers.. 
 */
public class V_220809 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Audit",
            "attr", "ProcessCreationIncludeCmdLine_Enabled",
            "result_value",  "1",
            "id", "V_220809"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Audit",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "attr", "ProcessCreationIncludeCmdLine_Enabled",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220809"),
            Map.entry("title", "Web publishing and online ordering wizards must be prevented from downloading a list of providers."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220809r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE \nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Audit\\\n\nValue Name: ProcessCreationIncludeCmdLine_Enabled\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22524r554912_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Audit Process Creation >> \"Include command line in process creation events\" to \"Enabled\"."),
            Map.entry("fixid", "F-22513r554913_fix"),
            Map.entry("description","Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\n\nEnabling \"Include command line data for process creation events\" will record the command line information with the process creation events in the log.  This can provide additional detail when malware has run on a system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000066")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220809() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220809();

        //running command line interface for V_220809
        cli(stig, args);
    }

}
