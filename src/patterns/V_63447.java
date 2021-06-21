package patterns;

public class V_63447 extends UserAccountManagementRequirement {
    @Override
    public String findingID() {
        return "V-63447";
    }

    @Override
    public String version() {
        return "WN10-AU-000035";
    }

    @Override
    public String ruleID() {
        return "SV-77937r1_rule";
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
        return "C-64195r1_chk";
    }

    @Override
    public String fixTextCode() {
        return "F-69375r1_fix";
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
    protected String getFailure() {
        return "enable";
    }
}