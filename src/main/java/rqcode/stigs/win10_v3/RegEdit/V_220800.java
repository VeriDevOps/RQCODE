package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220800: Local drives must be prevented from sharing with Remote Desktop Session Hosts.. 
 */
public class V_220800 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders\\Wdigest",
            "attr", "UseLogonCredential",
            "result_value",  "0",
            "id", "V_220800"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders\\Wdigest",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders",
            "attr", "UseLogonCredential",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220800"),
            Map.entry("title", "Local drives must be prevented from sharing with Remote Desktop Session Hosts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\\n\\nCredential validation records events related to validation tests on credentials for a user account logon."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MS Security Guide >> \\WDigest Authentication (disabling may require KB2871997)\\ to \\Disabled\\.\\n\\nThe patch referenced in the policy title is not required for Windows 10.\\n\\nThis policy setting requires the installation of the SecGuide custom templates included with the STIG package. \\SecGuide.admx\\ and \\SecGuide.adml\\ must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","When the WDigest Authentication protocol is enabled, plain text passwords are stored in the Local Security Authority Subsystem Service (LSASS) exposing them to theft. WDigest is disabled by default in Windows 10. This setting ensures this is enforced."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000038")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220800() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220800();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
