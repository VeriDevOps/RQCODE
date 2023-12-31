package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220910: Passwords must not be saved in the Remote Desktop Client.. 
 */
public class V_220910 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "attr", "LimitBlankPasswordUse",
            "result_value",  "1",
            "id", "V_220910"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
            "attr", "LimitBlankPasswordUse",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220910"),
            Map.entry("title", "Passwords must not be saved in the Remote Desktop Client."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220910r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Lsa\\\n\nValue Name: LimitBlankPasswordUse\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22625r555215_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Accounts: Limit local account use of blank passwords to console logon only\" to \"Enabled\"."),
            Map.entry("fixid", "F-22614r555216_fix"),
            Map.entry("description","An account without a password can allow unauthorized access to a system as only the username would be required.  Password policies should prevent accounts with blank passwords from existing on a system.  However, if a local account with a blank password did exist, enabling this setting will prevent network access, limiting the account to local console logon only."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000015")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220910() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220910();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
