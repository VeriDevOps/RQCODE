package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220862: The network selection user interface (UI) must not be displayed on the logon screen.. 
 */
public class V_220862 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Client",
            "attr", "AllowBasic",
            "result_value",  "0",
            "id", "V_220862"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Client",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM",
            "attr", "AllowBasic",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220862"),
            Map.entry("title", "The network selection user interface (UI) must not be displayed on the logon screen."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the system is configured to send audit records directly to an audit server, this is NA. This must be documented with the ISSO.\\n\\nIf the following registry value does not exist or is not configured as specified, this is a finding:\\n\\nRegistry Hive: HKEY_LOCAL_MACHINE\\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\Application\\\\n\\nValue Name: MaxSize\\n\\nValue Type: REG_DWORD\\nValue: 0x00008000 (32768) (or greater)"),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Remote Management (WinRM) >> WinRM Client >> \\Allow Basic authentication\\ to \\Disabled\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Basic authentication uses plain text passwords that could be used to compromise a system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000330")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220862() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220862();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
