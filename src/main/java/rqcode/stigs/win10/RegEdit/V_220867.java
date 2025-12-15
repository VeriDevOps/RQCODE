package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220867: The system must be configured to use FIPS-compliant algorithms for encryption, hashing, and signing.. 
 */
public class V_220867 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Service",
            "attr", "DisableRunAs",
            "result_value",  "1",
            "id", "V_220867"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Service",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM",
            "attr", "DisableRunAs",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220867"),
            Map.entry("title", "The system must be configured to use FIPS-compliant algorithms for encryption, hashing, and signing."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220867r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Service\\\n\nValue Name: DisableRunAs\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22582r555086_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Remote Management (WinRM) >> WinRM Service >> \"Disallow WinRM from storing RunAs credentials\" to \"Enabled\"."),
            Map.entry("fixid", "F-22571r555087_fix"),
            Map.entry("description","Storage of administrative credentials could allow unauthorized access.  Disallowing the storage of RunAs credentials for Windows Remote Management will prevent them from being used with plug-ins."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000355")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220867() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220867();

        //running command line interface for V_220867
        cli(stig, args);
    }

}
