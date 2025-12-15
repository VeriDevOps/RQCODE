package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220730: Automatically signing in the last interactive user after a system-initiated restart must be disabled.. 
 */
public class V_220730 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanmanServer\\Parameters",
            "attr", "SMB1",
            "result_value",  "0",
            "id", "V_220730"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanmanServer\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LanmanServer",
            "attr", "SMB1",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220730"),
            Map.entry("title", "Automatically signing in the last interactive user after a system-initiated restart must be disabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220730r793189_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Different methods are available to disable SMBv1 on Windows 10, if V-220729 is configured, this is NA.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Services\\LanmanServer\\Parameters\\\n\nValue Name: SMB1\n\nType: REG_DWORD\nValue: 0x00000000 (0)"),
            Map.entry("checkid", "C-22445r793188_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MS Security Guide >> \"Configure SMBv1 Server\" to \"Disabled\".\n\nThis policy setting requires the installation of the SecGuide custom templates included with the STIG package. \"SecGuide.admx\" and \"SecGuide.adml\" must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively.   \n\nThe system must be restarted for the change to take effect."),
            Map.entry("fixid", "F-22434r554676_fix"),
            Map.entry("description","SMBv1 is a legacy protocol that uses the MD5 algorithm as part of SMB. MD5 is known to be vulnerable to a number of attacks such as collision and preimage attacks as well as not being FIPS compliant.\n\nDisabling SMBv1 support may prevent access to file or print sharing resources with systems or devices that only support SMBv1. File shares and print services hosted on Windows Server 2003 are an example, however Windows Server 2003 is no longer a supported operating system. Some older network attached devices may only support SMBv1."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-00-000165")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220730() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220730();

        //running command line interface for V_220730
        cli(stig, args);
    }

}
