package rqcode.stigs.win10.patterns;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * General STIG requirement pattern for checking settings of Win10 Sensitive Privilege Use policies.
 */

public abstract class SensitivePrivilegeUseRequirement extends PrivilegeUseRequirement {
    
    @Override
    protected String getSubcategory() {
        return "Sensitive Privilege Use";
    }

    
    @Override
    public String description() {
        return "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Sensitive Privilege Use records events related to use of sensitive privileges, such as \"Act as part of the operating system\" or \"Debug programs\".";
    }

    
    @Override
    public String checkText() {
        return "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective.\n" +
                "\n" +
                "Use the AuditPol tool to review the current Audit Policy configuration:\n" +
                "Open a Command Prompt with elevated privileges (\"Run as Administrator\").\n" +
                "Enter \"AuditPol /get /category:*\".\n" +
                "\n" +
                "Compare the AuditPol settings with the following. If the system does not audit the following, this is a finding:\n" +
                "\n" +
                "Privilege Use >> Sensitive Privilege Use - Failure";
    }

    
    @Override
    public String fixText() {
        return "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Privilege Use >> \"Audit Sensitive Privilege Use\" with \""
                + getInclusionSetting() + "\" selected.";
    }

}
