package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220823: The system must be configured to the required LDAP client signing level.. 
 */
public class V_220823 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "attr", "fAllowToGetHelp",
            "result_value",  "0",
            "id", "V_220823"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT",
            "attr", "fAllowToGetHelp",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220823"),
            Map.entry("title", "The system must be configured to the required LDAP client signing level."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220823r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services\\\n\nValue Name: fAllowToGetHelp\n \nValue Type: REG_DWORD\nValue: 0"),
            Map.entry("checkid", "C-22538r554954_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Remote Assistance >> \"Configure Solicited Remote Assistance\" to \"Disabled\"."),
            Map.entry("fixid", "F-22527r554955_fix"),
            Map.entry("description","Remote assistance allows another user to view or take control of the local session of a user.  Solicited assistance is help that is specifically requested by the local user.  This may allow unauthorized parties access to the resources on the computer."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000155")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220823() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220823();

        //running command line interface for V_220823
        cli(stig, args);
    }

}
