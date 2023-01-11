package rqcode.stigs.win10.patterns;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * General STIG requirement pattern for checking settings of Win10 Sensitive Privilege Use policies.
 */
@objid ("7a13afc8-4aef-4163-b82d-0616a201cb1e")
public abstract class SensitivePrivilegeUseRequirement extends PrivilegeUseRequirement {
    @objid ("0f14567b-4523-42cc-8bb6-17e2581c382d")
    @Override
    protected String getSubcategory() {
        return "Sensitive Privilege Use";
    }

    @objid ("f20e6105-a822-433e-a695-d72616159199")
    @Override
    public String description() {
        return "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Sensitive Privilege Use records events related to use of sensitive privileges, such as \"Act as part of the operating system\" or \"Debug programs\".";
    }

    @objid ("45ec31e4-6f29-4ae9-b57d-7db182405ab9")
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

    @objid ("6928dfb3-dc4c-4074-ab80-e1332077e32e")
    @Override
    public String fixText() {
        return "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Privilege Use >> \"Audit Sensitive Privilege Use\" with \""
                + getInclusionSetting() + "\" selected.";
    }

}
