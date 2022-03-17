package rqcode.patterns.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * General STIG requirement pattern for checking settings of Win10 Logon functionality.
 */
@objid ("1d273dbd-d63a-47ee-96ca-2a4e4d7c1754")
public abstract class LogonRequirement extends LogonLogoffRequirement {
    @objid ("f58a8bc5-441d-4e67-b0c5-97c1a4b57239")
    @Override
    protected String getSubcategory() {
        return "Logon";
    }

    @objid ("fd505779-d6ad-4635-bf15-c030f341f71d")
    @Override
    public String description() {
        return "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed.";
    }

    @objid ("6e2de671-d8bc-4801-88f3-09be8ba46dba")
    @Override
    public String checkText() {
        return "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective."
                + "\n" + "\n" + "Use the AuditPol tool to review the current Audit Policy configuration:" + "\n"
                + "Open a Command Prompt with elevated privileges (\"Run as Administrator\")." + "\n"
                + "Enter \"AuditPol /get /category:*\"." + "\n" + "\n"
                + "Compare the AuditPol settings with the following. If the system does not audit the following, this is a finding:"
                + "\n" + "\n" + "Logon/Logoff >> Logon - Failure";
    }

    @objid ("3cc11fcd-ceb3-4f68-9cfd-9c5828db4bdc")
    @Override
    public String fixText() {
        return "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Logon/Logoff >> \"Audit Logon\" with \""
                + getInclusionSetting() + "\" selected.";
    }

}
