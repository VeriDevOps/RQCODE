package rqcode.stigs.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.patterns.win10.LogonRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed.
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63463
 */
@objid ("50566d10-2d9e-444e-a974-f8914b905475")
public class V_63463 extends LogonRequirement {
    @objid ("35b4bb55-341d-4c6a-89b5-91a05be848c7")
    @Override
    protected String getFailure() {
        return "enable";
    }

    @objid ("9ef3ee8b-32a6-42e4-b4b5-d3f259d7e6a0")
    @Override
    protected String getInclusionSetting() {
        return "Failure";
    }

    @objid ("6cc9b1a9-1d0e-466f-8588-0f8d77e66bf6")
    @Override
    protected String getSuccess() {
        return null;
    }

    @objid ("d746646a-df21-4afa-97e9-1b8d3a06e9b5")
    @Override
    public String checkTextCode() {
        return "C-64211r1_chk";
    }

    @objid ("5abe9c5a-73ea-4443-9f11-3862c731de7f")
    @Override
    public String date() {
        return "2020-06-15";
    }

    @objid ("dc482e90-09f3-4da7-a837-f59d31ddd979")
    @Override
    public String findingID() {
        return "V-63463";
    }

    @objid ("73a9ec82-147f-403d-95ee-666912115f04")
    @Override
    public String fixTextCode() {
        return "F-69391r1_fix";
    }

    @objid ("8fe1f12f-9d67-4bd8-afa1-bbc1947fb8d3")
    @Override
    public String iAControls() {
        return "";
    }

    @objid ("deae3bc2-6f87-43f4-a614-9fd76429f945")
    @Override
    public String ruleID() {
        return "SV-77953r1_rule";
    }

    @objid ("4c535d08-321e-45ed-9654-f76298bf4b11")
    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @objid ("7b56551a-e0fe-46d1-8c02-f83bbced29a2")
    @Override
    public String severity() {
        return "Medium";
    }

    @objid ("d3c5c5cf-c4d1-4392-bb6b-1da73eb8582e")
    @Override
    public String version() {
        return "WN10-AU-000070";
    }

}
