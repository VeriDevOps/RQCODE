package rqcode.stigs.win10;

import rqcode.patterns.win10.SensitivePrivilegeUseRequirement;

public class V_63483 extends SensitivePrivilegeUseRequirement {
    @Override
    protected String getFailure() {
        return "enable";
    }

    @Override
    protected String getInclusionSetting() {
        return "Failure";
    }

    @Override
    protected String getSuccess() {
        return null;
    }

    @Override
    public String checkTextCode() {
        return "C-64235r1_chk";
    }

    @Override
    public String date() {
        return "2020-06-15";
    }

    @Override
    public String findingID() {
        return "V-63483";
    }

    @Override
    public String fixTextCode() {
        return "F-69413r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77973r1_rule";
    }

    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @Override
    public String severity() {
        return "Medium";
    }

    @Override
    public String version() {
        return "WN10-AU-000110";
    }
}
