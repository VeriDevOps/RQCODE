package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220851: Windows 10 Kernel (Direct Memory Access) DMA Protection must be enabled.. 
 */
public class V_220851 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "attr", "fEncryptRPCTraffic",
            "result_value",  "1",
            "id", "V_220851"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows NT",
            "attr", "fEncryptRPCTraffic",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220851"),
            Map.entry("title", "Windows 10 Kernel (Direct Memory Access) DMA Protection must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220851r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Terminal Services\\\n\nValue Name: fEncryptRPCTraffic\n\nValue Type: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22566r555038_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Remote Desktop Services >> Remote Desktop Session Host >> Security \"Require secure RPC communication\" to \"Enabled\"."),
            Map.entry("fixid", "F-22555r555039_fix"),
            Map.entry("description","Allowing unsecure RPC communication exposes the system to man in the middle attacks and data disclosure attacks. A man in the middle attack occurs when an intruder captures packets between a client and server and modifies them before allowing the packets to be exchanged. Usually the attacker will modify the information in the packets in an attempt to cause either the client or server to reveal sensitive information."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000285")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220851() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220851();

        //running command line interface for V_220851
        cli(stig, args);
    }

}
