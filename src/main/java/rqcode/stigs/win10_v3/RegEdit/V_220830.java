package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220830: Enhanced anti-spoofing for facial recognition must be enabled on Window 10.. 
 */
public class V_220830 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Biometrics\\FacialFeatures",
            "attr", "EnhancedAntiSpoofing",
            "result_value",  "1",
            "id", "V_220830"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Biometrics\\FacialFeatures",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Biometrics",
            "attr", "EnhancedAntiSpoofing",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220830"),
            Map.entry("title", "Enhanced anti-spoofing for facial recognition must be enabled on Window 10."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220830r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Windows 10 v1507 LTSB version does not include this setting; it is NA for those systems.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Biometrics\\FacialFeatures\\\n\nValue Name: EnhancedAntiSpoofing\n\nValue Type: REG_DWORD\nValue: 0x00000001 (1)"),
            Map.entry("checkid", "C-22545r554975_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Biometrics >> Facial Features >> \"Configure enhanced anti-spoofing\" to \"Enabled\". \n\nv1607:\nThe policy name is \"Use enhanced anti-spoofing when available\"."),
            Map.entry("fixid", "F-22534r554976_fix"),
            Map.entry("description","Enhanced anti-spoofing provides additional protections when using facial recognition with devices that support it."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000195")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220830() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220830();

        //running command line interface for V_220830
        cli(stig, args);
    }

}
