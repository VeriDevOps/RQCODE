package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220916: Windows 10 must be configured to enable Remote host allows delegation of non-exportable credentials.. 
 */
public class V_220916 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "attr", "SignSecureChannel",
            "result_value",  "1",
            "id", "V_220916"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Netlogon",
            "attr", "SignSecureChannel",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220916"),
            Map.entry("title", "Windows 10 must be configured to enable Remote host allows delegation of non-exportable credentials."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220916r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters\\\n\nValue Name: SignSecureChannel\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22631r555233_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"Domain member: Digitally sign secure channel data (when possible)\" to \"Enabled\"."),
            Map.entry("fixid", "F-22620r555234_fix"),
            Map.entry("description","Requests sent on the secure channel are authenticated, and sensitive information (such as passwords) is encrypted, but the channel is not integrity checked.  If this policy is enabled, outgoing secure channel traffic will be signed."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000045")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220916() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220916();

        //running command line interface for V_220916
        cli(stig, args);
    }

}
