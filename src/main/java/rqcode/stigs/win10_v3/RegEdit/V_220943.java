package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220943: User Account Control must be configured to detect application installations and prompt for elevation.. 
 */
public class V_220943 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager",
            "attr", "ProtectionMode",
            "result_value",  "1",
            "id", "V_220943"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager",
            "attr", "ProtectionMode",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220943"),
            Map.entry("title", "User Account Control must be configured to detect application installations and prompt for elevation."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220943r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\\n\nValue Name: ProtectionMode\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22658r555314_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"System objects: Strengthen default permissions of internal system objects (e.g. Symbolic links)\" to \"Enabled\"."),
            Map.entry("fixid", "F-22647r555315_fix"),
            Map.entry("description","Windows systems maintain a global list of shared system resources such as DOS device names, mutexes, and semaphores. Each type of object is created with a default DACL that specifies who can access the objects with what permissions. If this policy is enabled, the default DACL is stronger, allowing non-admin users to read shared objects, but not modify shared objects that they did not create."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000240")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220943() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220943();

        //running command line interface for V_220943
        cli(stig, args);
    }

}
