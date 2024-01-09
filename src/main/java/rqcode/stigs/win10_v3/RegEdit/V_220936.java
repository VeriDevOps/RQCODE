package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220936: Windows 10 systems must use a BitLocker PIN for pre-boot authentication.. 
 */
public class V_220936 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Kerberos\\Parameters",
            "attr", "SupportedEncryptionTypes",
            "result_value",  "2147483640",
            "id", "V_220936"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Kerberos\\Parameters",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Kerberos",
            "attr", "SupportedEncryptionTypes",
            "result_value", "2147483640"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220936"),
            Map.entry("title", "Windows 10 systems must use a BitLocker PIN for pre-boot authentication."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220936r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Kerberos\\Parameters\\\n\nValue Name: SupportedEncryptionTypes\n\nValue Type: REG_DWORD\nValue: 0x7ffffff8 (2147483640)"),
            Map.entry("checkid", "C-22651r555293_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network security: Configure encryption types allowed for Kerberos\" to \"Enabled\" with only the following selected:\n\nAES128_HMAC_SHA1\nAES256_HMAC_SHA1\nFuture encryption types"),
            Map.entry("fixid", "F-22640r555294_fix"),
            Map.entry("description","Certain encryption types are no longer considered secure.  This setting configures a minimum encryption type for Kerberos, preventing the use of the DES and RC4 encryption suites."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000190")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220936() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220936();

        //running command line interface for V_220936
        cli(stig, args);
    }

}
