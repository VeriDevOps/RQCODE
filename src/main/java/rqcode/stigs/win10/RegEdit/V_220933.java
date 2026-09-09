package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220933: Remote calls to the Security Account Manager (SAM) must be restricted to Administrators.
 */
public class V_220933 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "attr", "RestrictRemoteSAM",
            "result_value",  "O:BAG:BAD:(A;;RC;;;BA)",
            "id", "V_220933"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
            "attr", "RestrictRemoteSAM",
            "result_value", "O:BAG:BAD:(A;;RC;;;BA)"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220933"),
            Map.entry("title", "Remote calls to the Security Account Manager (SAM) must be restricted to Administrators."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220933r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Windows 10 v1507 LTSB version does not include this setting, it is NA for those systems.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Lsa\\\n\nValue Name: RestrictRemoteSAM\n\nValue Type: REG_SZ\nValue: O:BAG:BAD:(A;;RC;;;BA)"),
            Map.entry("checkid", "C-22648r555284_chk"),
            Map.entry("fixtext", "Navigate to the policy Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Network access: Restrict clients allowed to make remote calls to SAM\".\n\nSelect \"Edit Security\" to configure the \"Security descriptor:\".\n\nAdd \"Administrators\" in \"Group or user names:\" if it is not already listed (this is the default).\n\nSelect \"Administrators\" in \"Group or user names:\".\n\nSelect \"Allow\" for \"Remote Access\" in \"Permissions for \"Administrators\".\n\nClick \"OK\".\n\nThe \"Security descriptor:\" must be populated with \"O:BAG:BAD:(A;;RC;;;BA) for the policy to be enforced."),
            Map.entry("fixid", "F-22637r555285_fix"),
            Map.entry("description", "The Windows Security Account Manager (SAM) stores users' passwords.  Restricting remote rpc connections to the SAM to Administrators helps protect those credentials."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000167")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220933() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220933();

        //running command line interface for V_220933
        cli(stig, args);
    }

}
