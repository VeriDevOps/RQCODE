package rqcode.stigs.win10;

import rqcode.patterns.win10.UserAccountManagementRequirement;

public class V_63449 extends UserAccountManagementRequirement {
    @Override
    public String findingID() {
        return "V-63449";
    }

    @Override
    public String version() {
        return "WN10-AU-000040";
    }

    @Override
    public String ruleID() {
        return "SV-77939r1_rule";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String severity() {
        return "Medium";
    }

    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @Override
    public String date() {
        return "2020-06-15";
    }

    @Override
    public String checkTextCode() {
        return "C-64197r1_chk";
    }

    @Override
    public String fixTextCode() {
        return "F-69377r1_fix";
    }

    @Override
    protected String getInclusionSetting() {
        return "Success";
    }

    @Override
    protected String getSuccess() {
        return "enable";
    }

    @Override
    protected String getFailure() {
        return null;
    }
}
