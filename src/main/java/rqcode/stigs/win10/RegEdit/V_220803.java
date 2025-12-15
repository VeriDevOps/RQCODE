package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220803: The Windows Remote Management (WinRM) client must not use Digest authentication.. 
 */
public class V_220803 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Network Connections",
            "attr", "NC_ShowSharedAccessUI",
            "result_value",  "0",
            "id", "V_220803"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Network Connections",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "NC_ShowSharedAccessUI",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220803"),
            Map.entry("title", "The Windows Remote Management (WinRM) client must not use Digest authentication."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220803r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\Network Connections\\\n\nValue Name: NC_ShowSharedAccessUI\n\nType: REG_DWORD\nValue: 0x00000000 (0)"),
            Map.entry("checkid", "C-22518r554894_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Network >> Network Connections >> \"Prohibit use of Internet Connection Sharing on your DNS domain network\" to \"Enabled\"."),
            Map.entry("fixid", "F-22507r554895_fix"),
            Map.entry("description","Internet connection sharing makes it possible for an existing internet connection, such as through wireless, to be shared and used by other systems essentially creating a mobile hotspot.  This exposes the system sharing the connection to others with potentially malicious purpose."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000044")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220803() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220803();

        //running command line interface for V_220803
        cli(stig, args);
    }

}
