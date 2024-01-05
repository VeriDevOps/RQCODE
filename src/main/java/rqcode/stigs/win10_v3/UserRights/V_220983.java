package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220983: The Take ownership of files or other objects user right must only be assigned to the Administrators group.. 
 */
public class V_220983 extends UserRightsStig2 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeTakeOwnershipPrivilege"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeTakeOwnershipPrivilege"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220983"),
            Map.entry("title", "The Take ownership of files or other objects user right must only be assigned to the Administrators group."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220983r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Windows 10 LTSC\\B versions do not support the Microsoft Store and modern apps; this is NA for those systems.\\n\\nIf the following registry value does not exist or is not configured as specified, this is a finding.\\n\\nRegistry Hive: HKEY_LOCAL_MACHINE\\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\\\n\\nValue Name: MSAOptional\\n\\nValue Type: REG_DWORD\\nValue: 0x00000001 (1)"),
            Map.entry("checkid", "C-22698r555434_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \\Take ownership of files or other objects\\ to only include the following groups or accounts:\\n\\nAdministrators"),
            Map.entry("fixid", "F-22687r555435_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\\n\\nAccounts with the \\Take ownership of files or other objects\\ user right can take ownership of objects and make changes."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000165")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220983() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        UserRightsStig1 stig = new V_220983();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
