package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220870: $title. 
 */
public class V_220870 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Syste",
            "attr", ""AllowDomainPINLogon",
            "result_value",  "$result_value",
            "id", "V_220870"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Syste",
            "path_short", "HKLM:\\Software\\Policies\\Microsoft\\Windows",
            "attr", ""AllowDomainPINLogon",
            "result_value", "$result_value"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220870"),
            Map.entry("title", "$title"),
            Map.entry("date", "$date"),
            Map.entry("ruleID", "$ruleID"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "$checktext"),
            Map.entry("checkid", "$checkid"),
            Map.entry("fixtext", "$fixtext"),
            Map.entry("fixid", "$fixid"),
            Map.entry("description","$description"),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000370")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220870() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220870();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
