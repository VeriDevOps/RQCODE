package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220920: User Account Control approval mode for the built-in Administrator must be enabled.. 
 */
public class V_220920 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "attr", "InactivityTimeoutSecs",
            "result_value",  "900",
            "id", "V_220920"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "InactivityTimeoutSecs",
            "result_value", "900"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220920"),
            Map.entry("title", "User Account Control approval mode for the built-in Administrator must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the device or operating system does not have a camera installed, this requirement is not applicable.\\n\\nThis requirement is not applicable to mobile devices (smartphones and tablets), where the use of the camera is a local AO decision.\\n\\nThis requirement is not applicable to dedicated VTC suites located in approved VTC locations that are centrally managed.\\n\\nFor an external camera, if there is not a method for the operator to manually disconnect camera at the end of collaborative computing sessions, this is a finding.\\n\\nFor a built-in camera, the camera must be protected by a camera cover (e.g. laptop camera cover slide) when not in use. If the built-in camera is not protected with a camera cover, or if the built-in\\ncamera is not disabled in the bios, this is a finding.\\n\\nIf the camera is not disconnected or covered, the following registry entry is required:\\n\\nRegistry Hive: HKEY_LOCAL_MACHINE\\nRegistryPath\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\CapabilityAccessManager\\ConsentStore\\webcam\\n\\nValue Name: Deny\\n\\nIf \\Value Name\\ is set to a value other than \\Deny\\ and the collaborative computing device has not been authorized for use, this is a finding.\\n"),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \\Interactive logon: Machine inactivity limit\\ to \\900\\ seconds\\ or less, excluding \\0\\ which is effectively disabled."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Unattended systems are susceptible to unauthorized use and should be locked when unattended. The screen saver should be set at a maximum of 15 minutes and be password protected. This protects critical and sensitive data from exposure to unauthorized personnel with physical access to the computer."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000070")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220920() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220920();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
