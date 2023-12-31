package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220981: The Profile single process user right must only be assigned to the Administrators group.. 
 */
public class V_220981 extends UserRightsStig1 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeProfileSingleProcessPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeProfileSingleProcessPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220981"),
            Map.entry("title", "The Profile single process user right must only be assigned to the Administrators group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220981r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\\n\\nRegistry Hive: HKEY_LOCAL_MACHINE\\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows NT\\Rpc\\\\n\\nValue Name: RestrictRemoteClients\\n\\nValue Type: REG_DWORD\\nValue: 1"),
            Map.entry("checkid", "C-22696r555428_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \\Profile single process\\ to only include the following groups or accounts:\\n\\nAdministrators"),
            Map.entry("fixid", "F-22685r555429_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\\n\\nAccounts with the \\Profile single process\\ user right can monitor non-system processes performance. An attacker could potentially use this to identify processes to attack."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000150")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220981() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        UserRightsStig1 stig = new V_220981();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
