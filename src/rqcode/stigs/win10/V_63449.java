package rqcode.stigs.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import rqcode.patterns.win10.UserAccountManagementRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63449
 */
@objid ("e15cbebb-872c-403e-8d8b-778ef01ad4bd")
public class V_63449 extends UserAccountManagementRequirement {
    @objid ("4949ece0-9196-4923-8a6f-afa1b0b59b7a")
    @Override
    public String findingID() {
        return "V-63449";
    }

    @objid ("d9d0caf5-7253-45b1-965b-5a113567d2ed")
    @Override
    public String version() {
        return "WN10-AU-000040";
    }

    @objid ("54d0882e-8b2e-4170-ab2e-bd86a75cdd16")
    @Override
    public String ruleID() {
        return "SV-77939r1_rule";
    }

    @objid ("c2c486d6-fc15-499a-8792-6f296bea9f85")
    @Override
    public String iAControls() {
        return "";
    }

    @objid ("3e67d087-bb71-4388-951e-9af3352f1e97")
    @Override
    public String severity() {
        return "Medium";
    }

    @objid ("54be6a6c-98d3-4671-b6f2-f86b9ffeb0b7")
    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @objid ("68272b59-70a8-4c0c-badf-4377d67e4cfc")
    @Override
    public String date() {
        return "2020-06-15";
    }

    @objid ("a8229b32-5483-4adc-ab35-e7cc0a2fcc69")
    @Override
    public String checkTextCode() {
        return "C-64197r1_chk";
    }

    @objid ("a8167bd2-aef6-4c83-af54-5725de5c84d0")
    @Override
    public String fixTextCode() {
        return "F-69377r1_fix";
    }

    @objid ("b427bb95-c500-4e84-a8b0-35c1a7c3499f")
    @Override
    protected String getInclusionSetting() {
        return "Success";
    }

    @objid ("759ee7ff-bc1d-4487-8999-9c1412cac745")
    @Override
    protected String getSuccess() {
        return "enable";
    }

    @objid ("989642bc-2f30-474d-9127-059499f34cd1")
    @Override
    protected String getFailure() {
        return null;
    }

}
