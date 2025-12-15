package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220842: The Windows Remote Management (WinRM) service must not allow unencrypted traffic.. 
 */
public class V_220842 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Internet Settings",
            "attr", "PreventCertErrorOverrides",
            "result_value",  "1",
            "id", "V_220842"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Internet Settings",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge",
            "attr", "PreventCertErrorOverrides",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220842"),
            Map.entry("title", "The Windows Remote Management (WinRM) service must not allow unencrypted traffic."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220842r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This setting is applicable starting with v1809 of Windows 10; it is NA for prior versions.\n\nWindows 10 LTSC\\B versions do not include Microsoft Edge; this is NA for those systems.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Internet Settings\\\n\nValue Name: PreventCertErrorOverrides\n\nType: REG_DWORD\nValue: 0x00000001 (1)"),
            Map.entry("checkid", "C-22557r555011_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Microsoft Edge >> \"Prevent certificate error overrides\" to \"Enabled\"."),
            Map.entry("fixid", "F-22546r555012_fix"),
            Map.entry("description","Web security certificates provide an indication whether a site is legitimate. This policy setting prevents the user from ignoring Secure Sockets Layer/Transport Layer Security (SSL/TLS) certificate errors that interrupt browsing."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000238")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220842() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220842();

        //running command line interface for V_220842
        cli(stig, args);
    }

}
