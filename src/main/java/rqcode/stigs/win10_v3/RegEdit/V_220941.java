package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220941: The convenience PIN for Windows 10 must be disabled.. 
 */
public class V_220941 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0",
            "attr", "NTLMMinServerSec",
            "result_value",  "537395200",
            "id", "V_220941"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "attr", "NTLMMinServerSec",
            "result_value", "537395200"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220941"),
            Map.entry("title", "The convenience PIN for Windows 10 must be disabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Internet connection sharing makes it possible for an existing internet connection, such as through wireless, to be shared and used by other systems essentially creating a mobile hotspot. This exposes the system sharing the connection to others with potentially malicious purpose."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \\Network security: Minimum session security for NTLM SSP based (including secure RPC) servers\\ to \\Require NTLMv2 session security\\ and \\Require 128-bit encryption\\ (all options selected)."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Microsoft has implemented a variety of security support providers for use with RPC sessions. All of the options must be enabled to ensure the maximum security level."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000220")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220941() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220941();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
