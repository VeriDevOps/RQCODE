package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220855: The system must be configured to require a strong session key.. 
 */
public class V_220855 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Windows Search",
            "attr", "AllowIndexingEncryptedStoresOrItems",
            "result_value",  "0",
            "id", "V_220855"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\Windows Search",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "AllowIndexingEncryptedStoresOrItems",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220855"),
            Map.entry("title", "The system must be configured to require a strong session key."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220855r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\Windows Search\\\n\nValue Name: AllowIndexingEncryptedStoresOrItems\n\nValue Type: REG_DWORD\nValue: 0"),
            Map.entry("checkid", "C-22570r555050_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Search >> \"Allow indexing of encrypted files\" to \"Disabled\"."),
            Map.entry("fixid", "F-22559r555051_fix"),
            Map.entry("description","Indexing of encrypted files may expose sensitive data.  This setting prevents encrypted files from being indexed."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000305")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220855() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220855();

        //running command line interface for V_220855
        cli(stig, args);
    }

}
