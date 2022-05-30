package main.java.rqcode.patterns.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * General STIG requirement pattern for checking settings of Win10 User Account Management policies.
 */
@objid ("9df97c61-7664-484f-b06e-60f7eae69a8b")
public abstract class UserAccountManagementRequirement extends AccountManagementRequirement {
    @objid ("cc1e4294-4276-48d2-a2d5-f4b9f9a61716")
    @Override
    protected String getSubcategory() {
        return "User Account Management";
    }

    @objid ("84874bcc-ad35-4fb6-b713-e305c7f6dac7")
    @Override
    public String description() {
        return "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to 1provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.";
    }

    @objid ("17a4af98-f738-41df-b1dc-1546e9e4a819")
    @Override
    public String checkText() {
        return "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective."
                + "\n" + "Use the AuditPol tool to review the current Audit Policy configuration:" + "\n"
                + "Open a Command Prompt with elevated privileges (\"Run as Administrator\")." + "\n"
                + "Enter \"AuditPol /get /category:*\"." + "\n"
                + "Compare the AuditPol settings with the following. If the system does not audit the following, this is a finding:"
                + "\n" + String.format("Account Management >> User Account Management - %s", getInclusionSetting());
    }

    @objid ("29972fe1-d4e4-4bd1-b989-cb444ee296bc")
    @Override
    public String fixText() {
        return String.format(
                "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Account Management >> \"Audit User Account Management\" with \"%s\" selected.",
                getInclusionSetting());
    }

}
