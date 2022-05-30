package main.java.rqcode.stigs.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import main.java.rqcode.patterns.win10.LogonRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed.
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63467
 */
@objid ("6b1232cc-8e00-4127-a035-bdfc97befb80")
public class V_63467 extends LogonRequirement {
    @objid ("2e1b7f0b-f7cf-455b-9647-a16daa05350c")
    @Override
    protected String getFailure() {
        return null;
    }

    @objid ("7273e867-eb2c-4952-9b6f-5cdfae009a36")
    @Override
    protected String getInclusionSetting() {
        return "Success";
    }

    @objid ("65cb7c8b-276d-45b3-a066-018ed7eeb3d3")
    @Override
    protected String getSuccess() {
        return "enable";
    }

    @objid ("1bf36d0b-0966-4a10-9053-1d5cda55e546")
    @Override
    public String checkTextCode() {
        return "C-64215r1_chk";
    }

    @objid ("3672a14d-5d64-4c65-9c6c-58b26419fc0d")
    @Override
    public String date() {
        return "2020-06-15";
    }

    @objid ("86c274ed-302c-4059-aa8c-e923a940f9fe")
    @Override
    public String findingID() {
        return "V-63467";
    }

    @objid ("ca353c81-c559-4449-8134-71eadda303a6")
    @Override
    public String fixTextCode() {
        return "F-69395r1_fix";
    }

    @objid ("c42741f9-baf6-4f08-85d0-2e0184597e71")
    @Override
    public String iAControls() {
        return "";
    }

    @objid ("636be0f8-d45a-4c03-b7ab-07ffc355042c")
    @Override
    public String ruleID() {
        return "SV-77957r1_rule";
    }

    @objid ("7db1edb5-a6b3-4903-ad44-7242fc3bc6d3")
    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @objid ("b1cc9b4b-a5e1-4f53-a8b3-d2bcba4b8ba5")
    @Override
    public String severity() {
        return "Medium";
    }

    @objid ("dd833a49-bcf1-49f3-a8b4-dfc2c77a8491")
    @Override
    public String version() {
        return "WN10-AU-000075";
    }

}
