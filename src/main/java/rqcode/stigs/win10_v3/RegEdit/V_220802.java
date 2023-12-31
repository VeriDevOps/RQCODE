package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220802: User Account Control must automatically deny elevation requests for standard users.. 
 */
public class V_220802 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\LanmanWorkstation",
            "attr", "AllowInsecureGuestAuth",
            "result_value",  "0",
            "id", "V_220802"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\LanmanWorkstation",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "AllowInsecureGuestAuth",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220802"),
            Map.entry("title", "User Account Control must automatically deny elevation requests for standard users."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220802r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Windows 10 v1507 LTSB version does not include this setting; it is NA for those systems.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\LanmanWorkstation\\\n\nValue Name: AllowInsecureGuestAuth\n\nType: REG_DWORD\nValue: 0x00000000 (0)"),
            Map.entry("checkid", "C-22517r554891_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Network >> Lanman Workstation >> \"Enable insecure guest logons\" to \"Disabled\"."),
            Map.entry("fixid", "F-22506r554892_fix"),
            Map.entry("description","Insecure guest logons allow unauthenticated access to shared folders.  Shared resources on a system must require authentication to establish proper access."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000040")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220802() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220802();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
