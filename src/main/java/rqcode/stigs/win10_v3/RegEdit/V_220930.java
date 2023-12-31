package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220930: Windows Telemetry must not be configured to Full.. 
 */
public class V_220930 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "attr", "RestrictAnonymous",
            "result_value",  "1",
            "id", "V_220930"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
            "attr", "RestrictAnonymous",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220930"),
            Map.entry("title", "Windows Telemetry must not be configured to Full."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220930r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Lsa\\\n\nValue Name: RestrictAnonymous\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22645r555275_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network access: Do not allow anonymous enumeration of SAM accounts and shares\" to \"Enabled\"."),
            Map.entry("fixid", "F-22634r555276_fix"),
            Map.entry("description","Allowing anonymous logon users (null session connections) to list all account names and enumerate all shared resources can provide a map of potential points to attack the system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000150")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220930() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220930();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
