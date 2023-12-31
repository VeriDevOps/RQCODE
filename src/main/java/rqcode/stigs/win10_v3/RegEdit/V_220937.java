package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220937: If Enhanced diagnostic data is enabled it must be limited to the minimum required to support Windows Analytics.. 
 */
public class V_220937 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "attr", "NoLMHash",
            "result_value",  "1",
            "id", "V_220937"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
            "attr", "NoLMHash",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220937"),
            Map.entry("title", "If Enhanced diagnostic data is enabled it must be limited to the minimum required to support Windows Analytics."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220937r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Lsa\\\n\nValue Name: NoLMHash\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22652r555296_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network security: Do not store LAN Manager hash value on next password change\" to \"Enabled\"."),
            Map.entry("fixid", "F-22641r555297_fix"),
            Map.entry("description","The LAN Manager hash uses a weak encryption algorithm and there are several tools available that use this hash to retrieve account passwords.  This setting controls whether or not a LAN Manager hash of the password is stored in the SAM the next time the password is changed."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000195")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220937() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220937();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
