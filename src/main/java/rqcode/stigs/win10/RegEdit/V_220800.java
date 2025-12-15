package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220800: Local drives must be prevented from sharing with Remote Desktop Session Hosts.. 
 */
public class V_220800 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders\\Wdigest",
            "attr", "UseLogonCredential",
            "result_value",  "0",
            "id", "V_220800"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders\\Wdigest",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders",
            "attr", "UseLogonCredential",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220800"),
            Map.entry("title", "Local drives must be prevented from sharing with Remote Desktop Session Hosts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220800r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\SecurityProviders\\Wdigest\\\n\nValue Name: UseLogonCredential\n\nType: REG_DWORD\nValue:  0x00000000 (0)"),
            Map.entry("checkid", "C-22515r554885_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MS Security Guide >> \"WDigest Authentication (disabling may require KB2871997)\" to \"Disabled\".\n\nThe patch referenced in the policy title is not required for Windows 10.\n\nThis policy setting requires the installation of the SecGuide custom templates included with the STIG package.  \"SecGuide.admx\" and \"SecGuide.adml\" must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22504r554886_fix"),
            Map.entry("description","When the WDigest Authentication protocol is enabled, plain text passwords are stored in the Local Security Authority Subsystem Service (LSASS) exposing them to theft.  WDigest is disabled by default in Windows 10.  This setting ensures this is enforced."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000038")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220800() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220800();

        //running command line interface for V_220800
        cli(stig, args);
    }

}
