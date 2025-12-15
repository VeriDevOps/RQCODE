package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220796: Attachments must be prevented from being downloaded from RSS feeds.. 
 */
public class V_220796 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters",
            "attr", "DisableIPSourceRouting",
            "result_value",  "2",
            "id", "V_220796"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip",
            "attr", "DisableIPSourceRouting",
            "result_value", "2"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220796"),
            Map.entry("title", "Attachments must be prevented from being downloaded from RSS feeds."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220796r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters\\\n\nValue Name: DisableIPSourceRouting\n\nValue Type: REG_DWORD\nValue: 2"),
            Map.entry("checkid", "C-22511r554873_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MSS (Legacy) >> \"MSS: (DisableIPSourceRouting) IP source routing protection level (protects against packet spoofing)\" to \"Highest protection, source routing is completely disabled\".\n\nThis policy setting requires the installation of the MSS-Legacy custom templates included with the STIG package.  \"MSS-Legacy.admx\" and \" MSS-Legacy.adml\" must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22500r554874_fix"),
            Map.entry("description","Configuring the system to disable IP source routing protects against spoofing."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000025")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220796() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220796();

        //running command line interface for V_220796
        cli(stig, args);
    }

}
