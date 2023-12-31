package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220940: Windows 10 should be configured to prevent users from receiving suggestions for third-party or additional applications.. 
 */
public class V_220940 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0",
            "attr", "NTLMMinClientSec",
            "result_value",  "537395200",
            "id", "V_220940"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "attr", "NTLMMinClientSec",
            "result_value", "537395200"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220940"),
            Map.entry("title", "Windows 10 should be configured to prevent users from receiving suggestions for third-party or additional applications."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220940r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0\\\n\nValue Name: NTLMMinClientSec\n\nValue Type: REG_DWORD\nValue: 0x20080000 (537395200)"),
            Map.entry("checkid", "C-22655r555305_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network security: Minimum session security for NTLM SSP based (including secure RPC) clients\" to \"Require NTLMv2 session security\" and \"Require 128-bit encryption\" (all options selected)."),
            Map.entry("fixid", "F-22644r555306_fix"),
            Map.entry("description","Microsoft has implemented a variety of security support providers for use with RPC sessions.  All of the options must be enabled to ensure the maximum security level."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000215")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220940() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220940();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
