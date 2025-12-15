package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220807: Credential Guard must be running on Windows 10 domain-joined systems.. 
 */
public class V_220807 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WcmSvc\\GroupPolicy",
            "attr", "fBlockNonDomain",
            "result_value",  "1",
            "id", "V_220807"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WcmSvc\\GroupPolicy",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WcmSvc",
            "attr", "fBlockNonDomain",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220807"),
            Map.entry("title", "Credential Guard must be running on Windows 10 domain-joined systems."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220807r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\WcmSvc\\GroupPolicy\\\n\nValue Name: fBlockNonDomain\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22522r554906_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Network >> Windows Connection Manager >> \"Prohibit connection to non-domain networks when connected to domain authenticated network\" to \"Enabled\"."),
            Map.entry("fixid", "F-22511r554907_fix"),
            Map.entry("description","Multiple network connections can provide additional attack vectors to a system and should be limited.  When connected to a domain, communication must go through the domain connection."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000060")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220807() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220807();

        //running command line interface for V_220807
        cli(stig, args);
    }

}
