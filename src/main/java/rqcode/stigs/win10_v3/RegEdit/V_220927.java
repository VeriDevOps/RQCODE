package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220927: Autoplay must be turned off for non-volume devices.. 
 */
public class V_220927 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanManServer\\Parameters",
            "attr", "RequireSecuritySignature",
            "result_value",  "1",
            "id", "V_220927"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanManServer\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanManServer",
            "attr", "RequireSecuritySignature",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220927"),
            Map.entry("title", "Autoplay must be turned off for non-volume devices."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220927r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Services\\LanManServer\\Parameters\\\n\nValue Name: RequireSecuritySignature\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22642r555266_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Microsoft network server: Digitally sign communications (always)\" to \"Enabled\"."),
            Map.entry("fixid", "F-22631r555267_fix"),
            Map.entry("description","The server message block (SMB) protocol provides the basis for many network operations.  Digitally signed SMB packets aid in preventing man-in-the-middle attacks.  If this policy is enabled, the SMB server will only communicate with an SMB client that performs SMB packet signing."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000120")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220927() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220927();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
