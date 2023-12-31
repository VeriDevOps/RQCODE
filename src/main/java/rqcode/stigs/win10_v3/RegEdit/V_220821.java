package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220821: PKU2U authentication using online identities must be prevented.. 
 */
public class V_220821 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings\\0e796bdb-100d-47d6-a2d5-f7d2daa51f51",
            "attr", "DCSettingIndex",
            "result_value",  "1",
            "id", "V_220821"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings\\0e796bdb-100d-47d6-a2d5-f7d2daa51f51",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings",
            "attr", "DCSettingIndex",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220821"),
            Map.entry("title", "PKU2U authentication using online identities must be prevented."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220821r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Power\\PowerSettings\\0e796bdb-100d-47d6-a2d5-f7d2daa51f51\\\n\nValue Name: DCSettingIndex\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22536r554948_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Power Management >> Sleep Settings >> \"Require a password when a computer wakes (on battery)\" to \"Enabled\"."),
            Map.entry("fixid", "F-22525r554949_fix"),
            Map.entry("description","Authentication must always be required when accessing a system.  This setting ensures the user is prompted for a password on resume from sleep (on battery)."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000145")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220821() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220821();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
