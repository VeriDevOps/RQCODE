package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220932: The Windows Defender SmartScreen for Explorer must be enabled.. 
 */
public class V_220932 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanManServer\\Parameters",
            "attr", "RestrictNullSessAccess",
            "result_value",  "1",
            "id", "V_220932"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanManServer\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanManServer",
            "attr", "RestrictNullSessAccess",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220932"),
            Map.entry("title", "The Windows Defender SmartScreen for Explorer must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220932r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "Allowing anonymous access to named pipes or shares provides the potential for unauthorized system access.  This setting restricts access to those defined in \"Network access: Named Pipes that can be accessed anonymously\" and \"Network access: Shares that can be accessed anonymously\",  both of which must be blank under other requirements."),
            Map.entry("checkid", "C-22647r555281_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network access: Restrict anonymous access to Named Pipes and Shares\" to \"Enabled\"."),
            Map.entry("fixid", "F-22636r555282_fix"),
            Map.entry("description","$description"),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000165")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220932() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220932();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
