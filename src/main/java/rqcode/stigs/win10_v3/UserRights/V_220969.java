package rqcode.stigs.win10_v3.UserRights;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220969: The Deny log on as a batch job user right on domain-joined workstations must be configured to prevent access from highly privileged domain accounts.. 
 */
public class V_220969 extends UserRightsStig1 {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "constantName", "SeDenyBatchLogonRight"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "constantName", "SeDenyBatchLogonRight"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220969"),
            Map.entry("title", "The Deny log on as a batch job user right on domain-joined workstations must be configured to prevent access from highly privileged domain accounts."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220969r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\\n\\nThe default behavior for \\Support device authentication using certificate\\ is \\Automatic\\.\\n\\nIf the registry value name below does not exist, this is not a finding.\\n\\nIf it exists and is configured with a value of \\1\\ this is not a finding.\\n\\nIf it exists and is configured with a value of \\0\\ this is a finding.\\n\\nRegistry Hive: HKEY_LOCAL_MACHINE\\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System\\Kerberos\\Parameters\\\\n\\nValue Name: DevicePKInitEnabled\\nValue Type: REG_DWORD\\nValue: 1 (or if the Value Name does not exist)"),
            Map.entry("checkid", "C-22684r555392_chk"),
            Map.entry("fixtext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\\n\\nConfigure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \\Deny log on as a batch job\\ to include the following.\\n\\nDomain Systems Only:\\nEnterprise Admin Group\\nDomain Admin Group"),
            Map.entry("fixid", "F-22673r555393_fix"),
            Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\\n\\nThe \\Deny log on as a batch job\\ right defines accounts that are prevented from logging on to the system as a batch job, such as Task Scheduler.\\n\\nIn an Active Directory Domain, denying logons to the Enterprise Admins and Domain Admins groups on lower trust systems helps mitigate the risk of privilege escalation from credential theft attacks which could lead to the compromise of an entire domain."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UR-000075")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220969() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        UserRightsStig1 stig = new V_220969();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
