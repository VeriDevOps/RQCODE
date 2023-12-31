package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220902: The Application event log size must be configured to 32768 KB or greater.. 
 */
public class V_220902 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Kernel DMA Protection",
            "attr", "DeviceEnumerationPolicy",
            "result_value",  "0",
            "id", "V_220902"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Kernel DMA Protection",
            "path_short", "HKLM:\\Software\\Policies\\Microsoft\\Windows",
            "attr", "DeviceEnumerationPolicy",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220902"),
            Map.entry("title", "The Application event log size must be configured to 32768 KB or greater."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220902r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This is NA prior to v1803 of Windows 10.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\Software\\Policies\\Microsoft\\Windows\\Kernel DMA Protection\n\nValue Name: DeviceEnumerationPolicy\nValue Type: REG_DWORD\nValue: 0"),
            Map.entry("checkid", "C-22617r555191_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Kernel DMA Protection >> \"Enumeration policy for external devices incompatible with Kernel DMA Protection\" to \"Enabled\" with \"Enumeration Policy\" set to \"Block All\"."),
            Map.entry("fixid", "F-22606r555192_fix"),
            Map.entry("description","Kernel DMA Protection to protect PCs against drive-by Direct Memory Access (DMA) attacks using PCI hot plug devices connected to Thunderbolt\u2122 3 ports. Drive-by DMA attacks can lead to disclosure of sensitive information residing on a PC, or even injection of malware that allows attackers to bypass the lock screen or control PCs remotely."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-EP-000310")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220902() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220902();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
