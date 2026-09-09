package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220813: Early Launch Antimalware, Boot-Start Driver Initialization Policy must prevent boot drivers.
 *
 * NOTE: the STIG accepts DriverLoadPolicy values 1, 3, or 8 as compliant (only 7 is a finding). This class checks for the Microsoft-documented default of 3 ("Good, unknown and bad but critical"); values 1 and 8 are also compliant but are not recognized as PASS by this equality check.
 */
public class V_220813 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Policies\\EarlyLaunch",
            "attr", "DriverLoadPolicy",
            "result_value",  "3",
            "id", "V_220813"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Policies\\EarlyLaunch",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Policies",
            "attr", "DriverLoadPolicy",
            "result_value", "3"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220813"),
            Map.entry("title", "Early Launch Antimalware, Boot-Start Driver Initialization Policy must prevent boot drivers."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220813r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "The default behavior is for Early Launch Antimalware - Boot-Start Driver Initialization policy is to enforce \"Good, unknown and bad but critical\" (preventing \"bad\").\n\nIf the registry value name below does not exist, this a finding.\n\nIf it exists and is configured with a value of \"7\", this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Policies\\EarlyLaunch\\\n\nValue Name: DriverLoadPolicy\n\nValue Type: REG_DWORD\nValue: 1, 3, or 8 \n\nPossible values for this setting are:\n8 - Good only\n1 - Good and unknown\n3 - Good, unknown and bad but critical\n7 - All (which includes \"Bad\" and would be a finding)\n"),
            Map.entry("checkid", "C-22528r554924_chk"),
            Map.entry("fixtext", "Ensure that Early Launch Antimalware - Boot-Start Driver Initialization policy is set to enforce \"Good, unknown and bad but critical\" (preventing \"bad\").\n\nIf this needs to be corrected configure the policy value for Computer Configuration >> Administrative Templates >> System >> Early Launch Antimalware >> \"Boot-Start Driver Initialization Policy\" to \"Enabled\u201d with \"Good, unknown and bad but critical\" selected."),
            Map.entry("fixid", "F-22517r554925_fix"),
            Map.entry("description", "By being launched first by the kernel, ELAM ( Early Launch Antimalware) is ensured to be launched before any third-party software, and is therefore able to detect malware in the boot process and prevent it from initializing."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000085")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220813() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220813();

        //running command line interface for V_220813
        cli(stig, args);
    }

}
