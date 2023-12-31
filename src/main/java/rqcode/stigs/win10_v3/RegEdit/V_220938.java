package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220938: Anonymous enumeration of shares must be restricted.. 
 */
public class V_220938 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "attr", "LmCompatibilityLevel",
            "result_value",  "5",
            "id", "V_220938"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
            "attr", "LmCompatibilityLevel",
            "result_value", "5"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220938"),
            Map.entry("title", "Anonymous enumeration of shares must be restricted."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220938r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Lsa\\\n\nValue Name: LmCompatibilityLevel\n\nValue Type: REG_DWORD\nValue: 5"),
            Map.entry("checkid", "C-22653r555299_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network security: LAN Manager authentication level\" to \"Send NTLMv2 response only. Refuse LM & NTLM\"."),
            Map.entry("fixid", "F-22642r555300_fix"),
            Map.entry("description","The Kerberos v5 authentication protocol is the default for authentication of users who are logging on to domain accounts.  NTLM, which is less secure, is retained in later Windows versions  for compatibility with clients and servers that are running earlier versions of Windows or applications that still use it.  It is also used to authenticate logons to stand-alone computers that are running later versions."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000205")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220938() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220938();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
