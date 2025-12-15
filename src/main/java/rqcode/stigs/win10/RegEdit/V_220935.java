package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220935: Windows 10 systems must use a BitLocker PIN with a minimum length of 6 digits for pre-boot authentication.. 
 */
public class V_220935 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\LSA\\pku2u",
            "attr", "AllowOnlineID",
            "result_value",  "0",
            "id", "V_220935"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\LSA\\pku2u",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\LSA",
            "attr", "AllowOnlineID",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220935"),
            Map.entry("title", "Windows 10 systems must use a BitLocker PIN with a minimum length of 6 digits for pre-boot authentication."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220935r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\LSA\\pku2u\\\n\nValue Name: AllowOnlineID\n\nValue Type: REG_DWORD\nValue: 0"),
            Map.entry("checkid", "C-22650r555290_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network security: Allow PKU2U authentication requests to this computer to use online identities\" to \"Disabled\"."),
            Map.entry("fixid", "F-22639r555291_fix"),
            Map.entry("description","PKU2U is a peer-to-peer authentication protocol.   This setting prevents online identities from authenticating to domain-joined systems.  Authentication will be centrally managed with Windows user accounts."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000185")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220935() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220935();

        //running command line interface for V_220935
        cli(stig, args);
    }

}
