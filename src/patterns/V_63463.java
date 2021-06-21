package patterns;

public class V_63463 extends LogonRequirement {
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
        return "C-64211r1_chk";
    }

    @Override
    public String date() {
        return "2020-06-15";
    }

    @Override
    public String findingID() {
        return "V-63463";
    }

    @Override
    public String fixTextCode() {
        return "F-69391r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77953r1_rule";
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
        return "WN10-AU-000070";
    }
}
