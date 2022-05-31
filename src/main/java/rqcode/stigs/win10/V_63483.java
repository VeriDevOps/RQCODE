package rqcode.stigs.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.patterns.win10.SensitivePrivilegeUseRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Sensitive Privilege Use records events related to use of sensitive privileges, such as "Act as part of the operating system" or "Debug programs".
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63483
 */
@objid ("9f9dffdd-2e9a-4f29-b787-bd539b8fbc1c")
public class V_63483 extends SensitivePrivilegeUseRequirement {
    @objid ("0dd5ebaa-3e4b-48fb-a3fb-06e0ff072176")
    @Override
    protected String getFailure() {
        return "enable";
    }

    @objid ("d5694b9a-31cf-4557-b5f9-ca8cced3b395")
    @Override
    protected String getInclusionSetting() {
        return "Failure";
    }

    @objid ("593f5709-1217-40ef-b496-f2c6b6086077")
    @Override
    protected String getSuccess() {
        return null;
    }

    @objid ("2e88fff2-1fbd-4356-84cc-ca73de915c8c")
    @Override
    public String checkTextCode() {
        return "C-64235r1_chk";
    }

    @objid ("cb57bc0c-a9de-4c4b-8344-39462438f429")
    @Override
    public String date() {
        return "2020-06-15";
    }

    @objid ("e1b38e19-292c-4490-97fc-6f7ff65eb675")
    @Override
    public String findingID() {
        return "V-63483";
    }

    @objid ("666a0407-5c01-4b53-9c7b-7e64922b6e83")
    @Override
    public String fixTextCode() {
        return "F-69413r1_fix";
    }

    @objid ("f9634122-4478-46c7-85a9-e200324dfdb5")
    @Override
    public String iAControls() {
        return "";
    }

    @objid ("e69ef3e3-71f9-4323-9408-50dd478b62d0")
    @Override
    public String ruleID() {
        return "SV-77973r1_rule";
    }

    @objid ("2df98583-9f0b-420a-8b98-786246151ff5")
    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @objid ("0b4c8ed5-7066-406a-a9d4-ccd5d02bf812")
    @Override
    public String severity() {
        return "Medium";
    }

    @objid ("33619e57-f0ba-4e98-8161-3c29c7351b36")
    @Override
    public String version() {
        return "WN10-AU-000110";
    }

}
