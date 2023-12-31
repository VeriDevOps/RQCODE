package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220846: IPv6 source routing must be configured to highest protection.. 
 */
public class V_220846 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\PassportForWork",
            "attr", "RequireSecurityDevice",
            "result_value",  "1",
            "id", "V_220846"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\PassportForWork",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft",
            "attr", "RequireSecurityDevice",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220846"),
            Map.entry("title", "IPv6 source routing must be configured to highest protection."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220846r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Virtual desktop implementations currently may not support the use of TPMs. For virtual desktop implementations where the virtual desktop instance is deleted or refreshed upon logoff, this is NA.\n\nIf the following registry value does not exist or is not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\PassportForWork\\\n\nValue Name: RequireSecurityDevice\n\nType: REG_DWORD\nValue: 1"),
            Map.entry("checkid", "C-22561r555023_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Hello for Business >> \"Use a hardware security device\" to \"Enabled\". \n\nv1507 LTSB:\nThe policy path is Computer Configuration >> Administrative Templates >> Windows Components >> Microsoft Passport for Work."),
            Map.entry("fixid", "F-22550r555024_fix"),
            Map.entry("description","The use of a Trusted Platform Module (TPM) to store keys for Windows Hello for Business provides additional security.  Keys stored in the TPM may only be used on that system while keys stored using software are more susceptible to compromise and could be used on other systems."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000255")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220846() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220846();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
