package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220795: Basic authentication for RSS feeds over HTTP must not be used.. 
 */
public class V_220795 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip6\\Parameters",
            "attr", "DisableIpSourceRouting",
            "result_value",  "2",
            "id", "V_220795"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip6\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip6",
            "attr", "DisableIpSourceRouting",
            "result_value", "2"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220795"),
            Map.entry("title", "Basic authentication for RSS feeds over HTTP must not be used."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220795r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Services\\Tcpip6\\Parameters\\\n\nValue Name: DisableIpSourceRouting\n\nValue Type: REG_DWORD\nValue: 2"),
            Map.entry("checkid", "C-22510r554870_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MSS (Legacy) >> \"MSS: (DisableIPSourceRouting IPv6) IP source routing protection level (protects against packet spoofing)\" to \"Highest protection, source routing is completely disabled\".\n\nThis policy setting requires the installation of the MSS-Legacy custom templates included with the STIG package.  \"MSS-Legacy.admx\" and \" MSS-Legacy.adml\" must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22499r554871_fix"),
            Map.entry("description","Configuring the system to disable IPv6 source routing protects against spoofing."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000020")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220795() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220795();

        //running command line interface for V_220795
        cli(stig, args);
    }

}
