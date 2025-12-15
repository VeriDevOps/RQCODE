package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

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
            Map.entry("ruleID", "SV_220941r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0\\\n\nValue Name: NTLMMinServerSec\n\nValue Type: REG_DWORD\nValue: 0x20080000 (537395200)"),
            Map.entry("checkid", "C-22656r555308_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network security: Minimum session security for NTLM SSP based (including secure RPC) servers\" to \"Require NTLMv2 session security\" and \"Require 128-bit encryption\" (all options selected)."),
            Map.entry("fixid", "F-22645r555309_fix"),
            Map.entry("description","Microsoft has implemented a variety of security support providers for use with RPC sessions.  All of the options must be enabled to ensure the maximum security level."),
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

        //running command line interface for V_220941
        cli(stig, args);
    }

}
