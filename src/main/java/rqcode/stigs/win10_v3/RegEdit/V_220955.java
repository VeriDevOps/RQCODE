package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220955: Audit policy using subcategories must be enabled.. 
 */
public class V_220955 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Attachments",
            "attr", "SaveZoneInformation",
            "result_value",  "2",
            "id", "V_220955"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Attachments",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "SaveZoneInformation",
            "result_value", "2"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220955"),
            Map.entry("title", "Audit policy using subcategories must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220955r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "The default behavior is for Windows to mark file attachments with their zone information.\n\nIf the registry Value Name below does not exist, this is not a finding.\n\nIf it exists and is configured with a value of \"2\", this is not a finding.\n\nIf it exists and is configured with a value of \"1\", this is a finding.\n\nRegistry Hive: HKEY_CURRENT_USER\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Attachments\\\n\nValue Name: SaveZoneInformation\n\nValue Type: REG_DWORD\nValue: 0x00000002 (2) (or if the Value Name does not exist)"),
            Map.entry("checkid", "C-22670r555350_chk"),
            Map.entry("fixtext", "The default behavior is for Windows to mark file attachments with their zone information.\n\nIf this needs to be corrected, configure the policy value for User Configuration >> Administrative Templates >> Windows Components >> Attachment Manager >> \"Do not preserve zone information in file attachments\" to \"Not Configured\" or \"Disabled\"."),
            Map.entry("fixid", "F-22659r555351_fix"),
            Map.entry("description","Preserving zone of origin (internet, intranet, local, restricted) information on file attachments allows Windows to determine risk."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UC-000020")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220955() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220955();

        //running command line interface for V_220955
        cli(stig, args);
    }

}
