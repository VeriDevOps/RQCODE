package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220806: Early Launch Antimalware, Boot-Start Driver Initialization Policy must prevent boot drivers.. 
 */
public class V_220806 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WcmSvc\\GroupPolicy",
            "attr", "fMinimizeConnections",
            "result_value",  "1",
            "id", "V_220806"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WcmSvc\\GroupPolicy",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WcmSvc",
            "attr", "fMinimizeConnections",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220806"),
            Map.entry("title", "Early Launch Antimalware, Boot-Start Driver Initialization Policy must prevent boot drivers."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220806r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "The default behavior for \"Minimize the number of simultaneous connections to the Internet or a Windows Domain\" is \"Enabled\".\n\nIf the registry value name below does not exist, this is not a finding.\n\nIf it exists and is configured with a value of \"1\", this is not a finding.\n\nIf it exists and is configured with a value of \"0\", this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\WcmSvc\\GroupPolicy\\\n\nValue Name: fMinimizeConnections\n\nValue Type: REG_DWORD\nValue: 1 (or if the Value Name does not exist)"),
            Map.entry("checkid", "C-22521r554903_chk"),
            Map.entry("fixtext", "The default behavior for \"Minimize the number of simultaneous connections to the Internet or a Windows Domain\" is \"Enabled\".\n\nIf this needs to be corrected, configure the policy value for Computer Configuration >> Administrative Templates >> Network >> Windows Connection Manager >> \"Minimize the number of simultaneous connections to the Internet or a Windows Domain\" to \"Enabled\"."),
            Map.entry("fixid", "F-22510r554904_fix"),
            Map.entry("description","Multiple network connections can provide additional attack vectors to a system and must be limited. The \"Minimize the number of simultaneous connections to the Internet or a Windows Domain\" setting prevents systems from automatically establishing multiple connections.  When both wired and wireless connections are available, for example, the less preferred connection (typically wireless) will be disconnected."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000055")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220806() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220806();

        //running command line interface for V_220806
        cli(stig, args);
    }

}
