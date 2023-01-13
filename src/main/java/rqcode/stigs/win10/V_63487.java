package rqcode.stigs.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.stigs.win10.patterns.SensitivePrivilegeUseRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Sensitive Privilege Use records events related to use of sensitive privileges, such as "Act as part of the operating system" or "Debug programs".
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63487
 */
@objid ("863f58b2-2432-4ca0-bd3f-a4fb48bda37c")
public class V_63487 extends SensitivePrivilegeUseRequirement {
    @objid ("b6f02ff2-a6dc-4231-a118-20b9c7226640")
    @Override
    protected String getFailure() {
        return null;
    }

    @objid ("ca9c59db-9574-4823-99f1-d01ab53730dc")
    @Override
    protected String getInclusionSetting() {
        return "Success";
    }

    @objid ("2263b8d1-6672-4b13-aaa8-63dfdf36af2f")
    @Override
    protected String getSuccess() {
        return "enable";
    }

    @objid ("1d0ac179-ef48-4a5b-bfa7-ae425d3d0905")
    @Override
    public String checkTextCode() {
        return "C-64237r1_chk";
    }

    @objid ("d898ab97-677b-4b40-961f-7c3498fefaa9")
    @Override
    public String date() {
        return "2020-06-15";
    }

    @objid ("acb55a08-5f23-4aad-a6a8-99248b400eaf")
    @Override
    public String findingID() {
        return "V-63487";
    }

    @objid ("4e16c168-50b4-4717-bec4-eb90826fbbeb")
    @Override
    public String fixTextCode() {
        return "F-69417r1_fix";
    }

    @objid ("682a07e6-482f-4987-a671-9e3376703fae")
    @Override
    public String iAControls() {
        return "";
    }

    @objid ("0b4157fe-bdd9-42ce-8c8a-ec8351077573")
    @Override
    public String ruleID() {
        return "SV-77977r1_rule";
    }

    @objid ("7a836e5f-41a1-412d-a4b8-66235155c9b3")
    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @objid ("b89591a8-94e7-46f9-8eba-d99e59927c6e")
    @Override
    public String severity() {
        return "Medium";
    }

    @objid ("e86c6204-d156-4b26-8a93-37ef174425f1")
    @Override
    public String version() {
        return "WN10-AU-000115";
    }

}
