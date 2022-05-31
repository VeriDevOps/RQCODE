package rqcode.stigs.win10;

        import rqcode.patterns.win10.UserRightsAssignRequirement;

public class V_63703 extends UserRightsAssignRequirement {
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
        return "C-64451r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63703";
    }

    @Override
    public String fixTextCode() {
        return "F-69629r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78193r1_rule";
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
        return "WN10-SO-000100";
    }
}
