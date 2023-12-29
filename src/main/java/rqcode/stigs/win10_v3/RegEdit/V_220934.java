package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220934: Anonymous access to attrd Pipes and Shares must be restricted.. 
 */
public class V_220934 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\LSA\\MSV1_0",
            "attr", "allownullsessionfallback",
            "result_value",  "0",
            "id", "V_220934"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\LSA\\MSV1_0",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\LSA",
            "attr", "allownullsessionfallback",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220934"),
            Map.entry("title", "Anonymous access to attrd Pipes and Shares must be restricted."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\\n\\nRegistry Hive: HKEY_LOCAL_MACHINE\\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders\\Wdigest\\\\n\\nValue Name: UseLogonCredential\\n\\nType: REG_DWORD\\nValue: 0x00000000 (0)"),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \\Network security: Allow LocalSystem NULL session fallback\\ to \\Disabled\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","NTLM sessions that are allowed to fall back to Null (unauthenticated) sessions may gain unauthorized access."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000180")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220934() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220934();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
