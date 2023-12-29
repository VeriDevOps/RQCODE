package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

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
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\\n\\nSensitive Privilege Use records events related to use of sensitive privileges, such as \\Act as part of the operating system\\ or \\Debug programs\\."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> PIN Complexity >> \\Minimum PIN length\\ to \\6\\ or greater. \\n\\nv1607 LTSB:\\nThe policy path is Computer Configuration >> Administrative Templates >> Windows Components >> Windows Hello for Business >> Pin Complexity.\\n\\nv1507 LTSB:\\nThe policy path is Computer Configuration >> Administrative Templates >> Windows Components >> Microsoft Passport for Work >> Pin Complexity."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Windows allows the use of PINs as well as biometrics for authentication without sending a password to a network or website where it could be compromised. Longer minimum PIN lengths increase the available combinations an attacker would have to attempt. Shorter minimum length significantly reduces the strength."),
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

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
