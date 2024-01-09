package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220799: Users must be prevented from changing installation options.. 
 */
public class V_220799 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "attr", "LocalAccountTokenFilterPolicy",
            "result_value",  "0",
            "id", "V_220799"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "path_short", "HKLM:SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "LocalAccountTokenFilterPolicy",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220799"),
            Map.entry("title", "Users must be prevented from changing installation options."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220799r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the system is not a member of a domain, this is NA.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\\n\nValue Name: LocalAccountTokenFilterPolicy\n\nValue Type: REG_DWORD\nValue: 0x00000000 (0)"),
            Map.entry("checkid", "C-22514r554882_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MS Security Guide >> \"Apply UAC restrictions to local accounts on network logons\" to \"Enabled\".\n\nThis policy setting requires the installation of the SecGuide custom templates included with the STIG package.  \"SecGuide.admx\" and \"SecGuide.adml\" must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22503r554883_fix"),
            Map.entry("description","A compromised local administrator account can provide means for an attacker to move laterally between domain systems.\n\nWith User Account Control enabled, filtering the privileged token for built-in administrator accounts will prevent the elevated privileges of these accounts from being used over the network."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000037")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220799() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220799();

        //running command line interface for V_220799
        cli(stig, args);
    }

}
