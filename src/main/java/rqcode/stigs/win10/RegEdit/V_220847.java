package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220847: The system must be configured to prevent IP source routing.. 
 */
public class V_220847 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\PassportForWork\\PINComplexity",
            "attr", "MinimumPINLength",
            "result_value",  "6",
            "id", "V_220847"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\PassportForWork\\PINComplexity",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\PassportForWork",
            "attr", "MinimumPINLength",
            "result_value", "6"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220847"),
            Map.entry("title", "The system must be configured to prevent IP source routing."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220847r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive:  HKEY_LOCAL_MACHINE\nRegistry Path:  \\SOFTWARE\\Policies\\Microsoft\\PassportForWork\\PINComplexity\\\n\nValue Name:  MinimumPINLength\n\nType:  REG_DWORD\nValue:  6 (or greater)"),
            Map.entry("checkid", "C-22562r555026_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> PIN Complexity >> \"Minimum PIN length\" to \"6\" or greater. \n\nv1607 LTSB:\nThe policy path is Computer Configuration >> Administrative Templates >> Windows Components >> Windows Hello for Business >> Pin Complexity.\n\nv1507 LTSB:\nThe policy path is Computer Configuration >> Administrative Templates >> Windows Components >> Microsoft Passport for Work >> Pin Complexity."),
            Map.entry("fixid", "F-22551r555027_fix"),
            Map.entry("description","Windows allows the use of PINs as well as biometrics for authentication without sending a password to a network or website where it could be compromised.  Longer minimum PIN lengths increase the available combinations an attacker would have to attempt.  Shorter minimum length significantly reduces the strength."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000260")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220847() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220847();

        //running command line interface for V_220847
        cli(stig, args);
    }

}
