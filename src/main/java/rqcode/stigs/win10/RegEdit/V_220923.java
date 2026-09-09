package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220923: Caching of logon credentials must be limited.
 *
 * NOTE: the STIG requires a value of 10 or less. This class checks for the documented default of 10.
 */
public class V_220923 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon",
            "attr", "CachedLogonsCount",
            "result_value",  "10",
            "id", "V_220923"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion",
            "attr", "CachedLogonsCount",
            "result_value", "10"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220923"),
            Map.entry("title", "Caching of logon credentials must be limited."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220923r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "This is the default configuration for this setting (10 logons to cache).\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive:  HKEY_LOCAL_MACHINE \nRegistry Path:  \\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\\n\nValue Name:  CachedLogonsCount\n\nValue Type:  REG_SZ\nValue:  10 (or less)\n\nThis setting only applies to domain-joined systems, however, it is configured by default on all systems."),
            Map.entry("checkid", "C-22638r555254_chk"),
            Map.entry("fixtext", "This is the default configuration for this setting (10 logons to cache).\n\nConfigure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Interactive logon: Number of previous logons to cache (in case domain controller is not available)\" to \"10\" logons or less.\n\nThis setting only applies to domain-joined systems, however, it is configured by default on all systems."),
            Map.entry("fixid", "F-22627r555255_fix"),
            Map.entry("description", "The default Windows configuration caches the last logon credentials for users who log on interactively to a system.  This feature is provided for system availability reasons, such as the user's machine being disconnected from the network or domain controllers being unavailable.  Even though the credential cache is well-protected, if a system is attacked, an unauthorized individual may isolate the password to a domain user account using a password-cracking program and gain access to the domain."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000085")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220923() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220923();

        //running command line interface for V_220923
        cli(stig, args);
    }

}
