package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220942: Group Policy objects must be reprocessed even if they have not changed.. 
 */
public class V_220942 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\FIPSAlgorithmPolicy",
            "attr", "Enabled",
            "result_value",  "1",
            "id", "V_220942"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\FIPSAlgorithmPolicy",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
            "attr", "Enabled",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220942"),
            Map.entry("title", "Group Policy objects must be reprocessed even if they have not changed."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220942r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Lsa\\FIPSAlgorithmPolicy\\\n\nValue Name: Enabled\n\nValue Type: REG_DWORD\nValue: 1\n \nWarning: Clients with this setting enabled will not be able to communicate via digitally encrypted or signed protocols with servers that do not support these algorithms.  Both the browser and web server must be configured to use TLS otherwise the browser will not be able to connect to a secure site."),
            Map.entry("checkid", "C-22657r555311_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> \"System cryptography: Use FIPS compliant algorithms for encryption, hashing, and signing\" to \"Enabled\"."),
            Map.entry("fixid", "F-22646r555312_fix"),
            Map.entry("description","This setting ensures that the system uses algorithms that are FIPS-compliant for encryption, hashing, and signing.  FIPS-compliant algorithms meet specific standards established by the U.S. Government and must be the algorithms used for all OS encryption functions."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-SO-000230")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220942() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220942();

        //running command line interface for V_220942
        cli(stig, args);
    }

}
