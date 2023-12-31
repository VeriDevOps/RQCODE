package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220962: The Create a pagefile user right must only be assigned to the Administrators group.. 
 */
public class V_220962 extends UserRightsStig1 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeCreatePagefilePrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeCreatePagefilePrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220962"),
            Map.entry("title", "The Create a pagefile user right must only be assigned to the Administrators group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220962r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Enabling this setting and then selecting the \\Process even if the Group Policy objects have not changed\\ option ensures that the policies will be reprocessed even if null have been changed. This way, any unauthorized changes are forced to match the domain-based group policy settings again."),
            Map.entry("checkid", "C-22677r555371_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \\Create a pagefile\\ to only include the following groups or accounts:\\n\\nAdministrators"),
            Map.entry("fixid", "F-22666r555372_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\\n\\nAccounts with the \\Create a pagefile\\ user right can change the size of a pagefile, which could affect system performance."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000040")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220962() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        UserRightsStig1 stig = new V_220962();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
