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
            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Kernel DMA Protectio",
            "attr", "DeviceEnumerationPolicy",
            "result_value",  "0",
            "id", "V_220902"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Kernel DMA Protectio",
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
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Verify the permissions on the System event log (System.evtx). Standard user accounts or groups must not have access. The default permissions listed below satisfy this requirement.\\n\\nEventlog - Full Control\\nSYSTEM - Full Control\\nAdministrators - Full Control\\n\\nThe default location is the \\%SystemRoot%\\SYSTEM32\\WINEVT\\LOGS\\ directory. They may have been moved to another folder.\\n\\nIf the permissions for these files are not as restrictive as the ACLs listed, this is a finding.\\n\\nNOTE: If \\APPLICATION PACKAGE AUTHORITY\\ALL APPLICATION PACKAGES\\ has Special Permissions, this would not be a finding."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> System >> Kernel DMA Protection >> \\Enumeration policy for external devices incompatible with Kernel DMA Protection\\ to \\Enabled\\ with \\Enumeration Policy\\ set to \\Block All\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Kernel DMA Protection to protect PCs against drive-by Direct Memory Access (DMA) attacks using PCI hot plug devices connected to Thunderbolt™ 3 ports. Drive-by DMA attacks can lead to disclosure of sensitive information residing on a PC, or even injection of malware that allows attackers to bypass the lock screen or control PCs remotely."),
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
