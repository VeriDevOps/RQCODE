package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220727: Local users on domain-joined computers must not be enumerated.. 
 */
public class V_220727 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\kernel",
            "attr", "DisableExceptionChainValidation",
            "result_value",  "0",
            "id", "V_220727"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\kernel",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager",
            "attr", "DisableExceptionChainValidation",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220727"),
            Map.entry("title", "Local users on domain-joined computers must not be enumerated."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220727r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "This is applicable to Windows 10 prior to v1709.\n\nVerify SEHOP is turned on.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\kernel\\\n\nValue Name: DisableExceptionChainValidation\n\nValue Type: REG_DWORD\nValue: 0x00000000 (0)"),
            Map.entry("checkid", "C-22442r554666_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MS Security Guide >> \"Enable Structured Exception Handling Overwrite Protection (SEHOP)\" to \"Enabled\".\n\nThis policy setting requires the installation of the SecGuide custom templates included with the STIG package. \"SecGuide.admx\" and \"SecGuide.adml\" must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22431r554667_fix"),
            Map.entry("description","Attackers are constantly looking for vulnerabilities in systems and applications. Structured Exception Handling Overwrite Protection (SEHOP) blocks exploits that use the Structured Exception Handling overwrite technique, a common buffer overflow attack."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-00-000150")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220727() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220727();

        //running command line interface for V_220727
        cli(stig, args);
    }

}
