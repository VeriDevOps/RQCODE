package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220914: The user must be prompted for a password on resume from sleep (plugged in).. 
 */
public class V_220914 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "attr", "RequireSignOrSeal",
            "result_value",  "1",
            "id", "V_220914"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon",
            "attr", "RequireSignOrSeal",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220914"),
            Map.entry("title", "The user must be prompted for a password on resume from sleep (plugged in)."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220914r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters\\\n\nValue Name: RequireSignOrSeal\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22629r555227_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Domain member: Digitally encrypt or sign secure channel data (always)\" to \"Enabled\"."),
            Map.entry("fixid", "F-22618r555228_fix"),
            Map.entry("description","Requests sent on the secure channel are authenticated, and sensitive information (such as passwords) is encrypted, but not all information is encrypted.  If this policy is enabled, outgoing secure channel traffic will be encrypted and signed."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000035")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220914() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220914();

        //running command line interface for V_220914
        cli(stig, args);
    }

}
