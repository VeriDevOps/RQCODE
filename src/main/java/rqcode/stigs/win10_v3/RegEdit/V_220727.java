package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220727: Local users on domain-joined computers must not be enumerated.. 
 */
public class V_220727 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\kernel",
            "attr", "DisableExceptionChainValidation",
            "result_value",  "0",
            "id", "V_220727"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\kernel",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager",
            "attr", "DisableExceptionChainValidation",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220727"),
            Map.entry("title", "Local users on domain-joined computers must not be enumerated."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "Run \\Computer Management\\.\\nNavigate to System Tools >> Local Users and Groups >> Groups.\\nReview the members of the Administrators group.\\nOnly the appropriate administrator groups or accounts responsible for administration of the system may be members of the group.\\n\\nFor domain-joined workstations, the Domain Admins group must be replaced by a domain workstation administrator group.\\n\\nStandard user accounts must not be members of the local administrator group.\\n\\nIf prohibited accounts are members of the local administrators group, this is a finding.\\n\\nThe built-in Administrator account or other required administrative accounts would not be a finding."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MS Security Guide >> \\Enable Structured Exception Handling Overwrite Protection (SEHOP)\\ to \\Enabled\\.\\n\\nThis policy setting requires the installation of the SecGuide custom templates included with the STIG package. \\SecGuide.admx\\ and \\SecGuide.adml\\ must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Attackers are constantly looking for vulnerabilities in systems and applications. Structured Exception Handling Overwrite Protection (SEHOP) blocks exploits that use the Structured Exception Handling overwrite technique, a common buffer overflow attack."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-00-000150")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220727() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220727();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
