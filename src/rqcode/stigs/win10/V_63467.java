package rqcode.stigs.win10;

import rqcode.patterns.win10.LogonRequirement;

public class V_63467 extends LogonRequirement {
    @Override
    protected String getFailure() {
        return null;
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
    public String checkTextCode() {
        return "C-64215r1_chk";
    }

    @Override
    public String date() {
        return "2020-06-15";
    }

    @Override
    public String findingID() {
        return "V-63467";
    }

    @Override
    public String fixTextCode() {
        return "F-69395r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77957r1_rule";
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
        return "WN10-AU-000075";
    }
}
