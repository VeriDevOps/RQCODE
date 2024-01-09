package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220829: User Account Control must only elevate UIAccess applications that are installed in secure locations.. 
 */
public class V_220829 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\policies\\Explorer",
            "attr", "NoDriveTypeAutoRun",
            "result_value",  "255",
            "id", "V_220829"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\policies\\Explorer",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\policies",
            "attr", "NoDriveTypeAutoRun",
            "result_value", "255"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220829"),
            Map.entry("title", "User Account Control must only elevate UIAccess applications that are installed in secure locations."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220829r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path:  \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\policies\\Explorer\\\n\nValue Name: NoDriveTypeAutoRun\n\nValue Type: REG_DWORD\nValue: 0x000000ff (255)\n\nNote: If the value for NoDriveTypeAutorun is entered manually, it must be entered as \"ff\" when Hexadecimal is selected, or \"255\" with Decimal selected.  Using the policy value specified in the Fix section will enter it correctly."),
            Map.entry("checkid", "C-22544r554972_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> AutoPlay Policies >> \"Turn off AutoPlay\" to \"Enabled:All Drives\"."),
            Map.entry("fixid", "F-22533r554973_fix"),
            Map.entry("description","Allowing autoplay to execute may introduce malicious code to a system.  Autoplay begins reading from a drive as soon as you insert media in the drive.  As a result, the setup file of programs or music on audio media may start.  By default, autoplay is disabled on removable drives, such as the floppy disk drive (but not the CD-ROM drive) and on network drives.  If you enable this policy, you can also disable autoplay on all drives."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000190")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220829() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220829();

        //running command line interface for V_220829
        cli(stig, args);
    }

}
