package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 *  : $title. 
 */
public class   extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "$path",
            "attr", "$attr",
            "result_value",  "$result_value",
            "id", " "
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "$path",
            "path_short", "$path_short",
            "attr", "$attr",
            "result_value", "$result_value"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", " "),
            Map.entry("title", "$title"),
            Map.entry("date", "$date"),
            Map.entry("ruleID", "$ruleID"),
            Map.entry("severity", "$severity"),
            Map.entry("checktext", "$checktext"),
            Map.entry("checkid", "$checkid"),
            Map.entry("fixtext", "$fixtext"),
            Map.entry("fixid", "$fixid"),
            Map.entry("description","$description"),
            Map.entry("iacontrols", "$iacontrols"),
            Map.entry("version", "$version")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public   {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new  ();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
