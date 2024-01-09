package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220824: Kerberos encryption types must be configured to prevent the use of DES and RC4 encryption suites.. 
 */
public class V_220824 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Rpc",
            "attr", "RestrictRemoteClients",
            "result_value",  "1",
            "id", "V_220824"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Rpc",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT",
            "attr", "RestrictRemoteClients",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220824"),
            Map.entry("title", "Kerberos encryption types must be configured to prevent the use of DES and RC4 encryption suites."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220824r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Rpc\\\n\nValue Name: RestrictRemoteClients\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22539r554957_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Remote Procedure Call >> \"Restrict Unauthenticated RPC clients\" to \"Enabled\" and \"Authenticated\"."),
            Map.entry("fixid", "F-22528r554958_fix"),
            Map.entry("description","Configuring RPC to restrict unauthenticated RPC clients from connecting to the RPC server will prevent anonymous connections."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000165")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220824() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220824();

        //running command line interface for V_220824
        cli(stig, args);
    }

}
