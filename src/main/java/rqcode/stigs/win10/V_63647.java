package rqcode.stigs.win10;

import rqcode.patterns.win10.UserRightsAssignRequirement;

public class V_63647 extends UserRightsAssignRequirement {
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
        return "C-64397r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63647";
    }

    @Override
    public String fixTextCode() {
        return "F-69577r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78137r1_rule";
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
        return "WN10-SO-000045";
    }

    @Override
    protected String getSubcategory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String checkText() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String fixText() {
        // TODO Auto-generated method stub
        return null;
    }
}

