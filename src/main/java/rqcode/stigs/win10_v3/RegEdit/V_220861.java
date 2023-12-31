package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220861: Windows Ink Workspace must be configured to disallow access above the lock.. 
 */
public class V_220861 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer",
            "attr", "NoReadingPane",
            "result_value",  "1",
            "id", "V_220861"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "NoReadingPane",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220861"),
            Map.entry("title", "Windows Ink Workspace must be configured to disallow access above the lock."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220861r569305_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry values do not exist or are not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_CURRENT_USER\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\n\nValue Name: NoPreviewPane\n\nValue Type: REG_DWORD\n\nValue: 1\n\nRegistry Hive: HKEY_CURRENT_USER\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\n\nValue Name: NoReadingPane\n\nValue Type: REG_DWORD\n\nValue: 1"),
            Map.entry("checkid", "C-22576r603220_chk"),
            Map.entry("fixtext", "Ensure the following settings are configured for Windows 10 locally or applied through group policy. \n\nConfigure the policy value for User Configuration >> Administrative Templates >> Windows Components >> File Explorer >> Explorer Frame Pane \"Turn off Preview Pane\" to \"Enabled\".\n\nConfigure the policy value for User Configuration >> Administrative Templates >> Windows Components >> File Explorer >> Explorer Frame Pane \"Turn on or off details pane\" to \"Enabled\" and \"Configure details pane\" to \"Always hide\"."),
            Map.entry("fixid", "F-22565r603223_fix"),
            Map.entry("description","A known vulnerability in Windows 10 could allow the execution of malicious code by either opening a compromised document or viewing it in the Windows Preview pane.\n\nOrganizations must disable the Windows Preview pane and Windows Detail pane."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000328")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220861() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220861();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
