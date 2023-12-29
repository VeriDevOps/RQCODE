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
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explore",
            "attr", "NoReadingPane",
            "result_value",  "1",
            "id", "V_220861"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explore",
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
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\\n\\nSystem Integrity records events related to violations of integrity to the security subsystem."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Ensure the following settings are configured for Windows 10 locally or applied through group policy. \\n\\nConfigure the policy value for User Configuration >> Administrative Templates >> Windows Components >> File Explorer >> Explorer Frame Pane \\Turn off Preview Pane\\ to \\Enabled\\.\\n\\nConfigure the policy value for User Configuration >> Administrative Templates >> Windows Components >> File Explorer >> Explorer Frame Pane \\Turn on or off details pane\\ to \\Enabled\\ and \\Configure details pane\\ to \\Always hide\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","A known vulnerability in Windows 10 could allow the execution of malicious code by either opening a compromised document or viewing it in the Windows Preview pane.\\n\\nOrganizations must disable the Windows Preview pane and Windows Detail pane."),
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
