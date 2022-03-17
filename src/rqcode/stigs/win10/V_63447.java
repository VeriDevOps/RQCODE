package rqcode.stigs.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import rqcode.patterns.win10.UserAccountManagementRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63447
 */
@objid ("d4e7cbd0-9744-45b3-b822-0be9fce51bca")
public class V_63447 extends UserAccountManagementRequirement {
    @objid ("d9e852fc-e1d2-449d-86cf-c020df156ff9")
    @Override
    public String findingID() {
        return "V-63447";
    }

    @objid ("d87a45fd-7453-47dd-8738-4a83afe1b179")
    @Override
    public String version() {
        return "WN10-AU-000035";
    }

    @objid ("4b7d627e-765d-4fd0-8b3c-65d8c8d74031")
    @Override
    public String ruleID() {
        return "SV-77937r1_rule";
    }

    @objid ("b3fe9c8c-df4b-4a09-8e11-ac942e705018")
    @Override
    public String iAControls() {
        return "";
    }

    @objid ("a1a2b227-76ff-4c9d-b498-ce34b58ae4d6")
    @Override
    public String severity() {
        return "Medium";
    }

    @objid ("b3bbf58c-2db4-4788-969a-9a090f10fa24")
    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @objid ("894f03c3-cf02-455f-897b-d9f62fe0b1da")
    @Override
    public String date() {
        return "2020-06-15";
    }

    @objid ("a2aee2b7-b436-47d9-afd4-714a69fdc645")
    @Override
    public String checkTextCode() {
        return "C-64195r1_chk";
    }

    @objid ("0b67fd64-387a-48df-b890-54a096a6219c")
    @Override
    public String fixTextCode() {
        return "F-69375r1_fix";
    }

    @objid ("949bf04d-45c5-499b-97d6-306c2bef6a74")
    @Override
    protected String getInclusionSetting() {
        return "Failure";
    }

    @objid ("60798a15-a448-4ff1-9537-b876b4bcc212")
    @Override
    protected String getSuccess() {
        return null;
    }

    @objid ("95b6d385-e577-4961-be38-10580e1f8eaa")
    @Override
    protected String getFailure() {
        return "enable";
    }

}
