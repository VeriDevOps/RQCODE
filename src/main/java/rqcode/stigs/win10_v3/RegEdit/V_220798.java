package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220798: The Windows Installer Always install with elevated privileges must be disabled.. 
 */
public class V_220798 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netbt\\Parameters",
            "attr", "NoattrReleaseOnDemand",
            "result_value",  "1",
            "id", "V_220798"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netbt\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netbt",
            "attr", "NoattrReleaseOnDemand",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220798"),
            Map.entry("title", "The Windows Installer Always install with elevated privileges must be disabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220798r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive:  HKEY_LOCAL_MACHINE\nRegistry Path:  \\SYSTEM\\CurrentControlSet\\Services\\Netbt\\Parameters\\\n\nValue Name:  NoNameReleaseOnDemand\n\nValue Type:  REG_DWORD\nValue:  1"),
            Map.entry("checkid", "C-22513r554879_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MSS (Legacy) >> \"MSS: (NoNameReleaseOnDemand) Allow the computer to ignore NetBIOS name release requests except from WINS servers\" to \"Enabled\".\n\nThis policy setting requires the installation of the MSS-Legacy custom templates included with the STIG package.  \"MSS-Legacy.admx\" and \" MSS-Legacy.adml\" must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22502r554880_fix"),
            Map.entry("description","Configuring the system to ignore name release requests, except from WINS servers, prevents a denial of service (DoS) attack. The DoS consists of sending a NetBIOS name release request to the server for each entry in the server's cache, causing a response delay in the normal operation of the servers WINS resolution capability."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000035")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220798() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220798();

        //running command line interface for V_220798
        cli(stig, args);
    }

}
