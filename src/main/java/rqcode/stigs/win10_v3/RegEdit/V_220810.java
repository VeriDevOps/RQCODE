package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220810: The Application Compatibility Program Inventory must be prevented from collecting data and sending the information to Microsoft.. 
 */
public class V_220810 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CredentialsDelegation",
            "attr", "AllowProtectedCreds",
            "result_value",  "1",
            "id", "V_220810"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CredentialsDelegation",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "AllowProtectedCreds",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220810"),
            Map.entry("title", "The Application Compatibility Program Inventory must be prevented from collecting data and sending the information to Microsoft."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220810r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This is NA for Windows 10 LTSC\\B versions 1507 and 1607.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\CredentialsDelegation\\\n\nValue Name: AllowProtectedCreds\n\nType: REG_DWORD\nValue: 0x00000001 (1)"),
            Map.entry("checkid", "C-22525r554915_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Credentials Delegation >> \"Remote host allows delegation of non-exportable credentials\" to \"Enabled\"."),
            Map.entry("fixid", "F-22514r554916_fix"),
            Map.entry("description","An exportable version of credentials is provided to remote hosts when using credential delegation which exposes them to theft on the remote host.  Restricted Admin mode or Remote Credential Guard allow delegation of non-exportable credentials providing additional protection of the credentials.  Enabling this configures the host to support Restricted Admin mode or Remote Credential Guard."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000068")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220810() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220810();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
