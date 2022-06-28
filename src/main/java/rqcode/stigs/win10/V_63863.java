package rqcode.stigs.win10;

import rqcode.patterns.win10.NoUserRightsAssignRequirement;

public class V_63863 extends NoUserRightsAssignRequirement {
    @Override
    protected String getFailure() {
        return null;
    }

    @Override
    protected String getInclusionSetting() {
        return "Create permanent shared objects";
    }

    @Override
    protected String getSuccess() {
        return "enable";
    }

    @Override
    public String checkTextCode() {
        return "C-64613r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63863";
    }

    @Override
    public String fixTextCode() {
        return "F-69791r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78353r1_rule";
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
        return "WN10-UR-000055";
    }

    @Override
    public String description() {
        return "Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the \"Create permanent shared objects\" user right could expose sensitive data by creating shared objects.";
    }
}

