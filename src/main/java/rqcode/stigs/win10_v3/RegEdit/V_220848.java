package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220848: The Server Message Block (SMB) v1 protocol must be disabled on the SMB client.. 
 */
public class V_220848 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "attr", "DisablePasswordSaving",
            "result_value",  "1",
            "id", "V_220848"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT",
            "attr", "DisablePasswordSaving",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220848"),
            Map.entry("title", "The Server Message Block (SMB) v1 protocol must be disabled on the SMB client."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220848r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services\\\n\nValue Name: DisablePasswordSaving\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22563r555029_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Remote Desktop Services >> Remote Desktop Connection Client >> \"Do not allow passwords to be saved\" to \"Enabled\"."),
            Map.entry("fixid", "F-22552r555030_fix"),
            Map.entry("description","Saving passwords in the Remote Desktop Client could allow an unauthorized user to establish a remote desktop session to another system.  The system must be configured to prevent users from saving passwords in the Remote Desktop Client."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000270")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220848() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220848();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
