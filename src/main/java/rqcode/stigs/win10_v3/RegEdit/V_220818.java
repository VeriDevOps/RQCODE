package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220818: Windows 10 must be configured to disable Windows Game Recording and Broadcasting.. 
 */
public class V_220818 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Kerberos\\Parameters",
            "attr", "DevicePKInitEnabled",
            "result_value",  "1",
            "id", "V_220818"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Kerberos\\Parameters",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Kerberos",
            "attr", "DevicePKInitEnabled",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220818"),
            Map.entry("title", "Windows 10 must be configured to disable Windows Game Recording and Broadcasting."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220818r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\n\nThe default behavior for \"Support device authentication using certificate\" is \"Automatic\".\n\nIf the registry value name below does not exist, this is not a finding.\n\nIf it exists and is configured with a value of \"1\", this is not a finding.\n\nIf it exists and is configured with a value of \"0\", this is a finding.\n\nRegistry Hive:  HKEY_LOCAL_MACHINE\nRegistry Path:  \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Kerberos\\Parameters\\\n\nValue Name:  DevicePKInitEnabled\nValue Type:  REG_DWORD\nValue:  1 (or if the Value Name does not exist)"),
            Map.entry("checkid", "C-22533r554939_chk"),
            Map.entry("fixtext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\n\nThe default behavior for \"Support device authentication using certificate\" is \"Automatic\".\n\nIf this needs to be corrected, configured the policy value for Computer Configuration >> Administrative Templates >> System >> Kerberos >> \"Support device authentication using certificate\" to \"Not Configured or \"Enabled\" with either option selected in \"Device authentication behavior using certificate:\"."),
            Map.entry("fixid", "F-22522r554940_fix"),
            Map.entry("description","Using certificates to authenticate devices to the domain provides increased security over passwords.  By default systems will attempt to authenticate using certificates and fall back to passwords if the domain controller does not support certificates for devices.  This may also be configured to always use certificates for device authentication."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000115")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220818() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220818();

        //running command line interface for V_220818
        cli(stig, args);
    }

}
