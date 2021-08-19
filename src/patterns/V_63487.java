package patterns;

public class V_63487 extends SensitivePrivilegeUseRequirement {
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
        return "C-64237r1_chk";
    }

    @Override
    public String date() {
        return "2020-06-15";
    }

    @Override
    public String findingID() {
        return "V-63487";
    }

    @Override
    public String fixTextCode() {
        return "F-69417r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77977r1_rule";
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
        return "WN10-AU-000115";
    }
}
