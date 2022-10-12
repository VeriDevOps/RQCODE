package rqcode.stigs.win10;

        import rqcode.patterns.win10.PasswordPolicy;

/**
 *Storing passwords using reversible encryption is essentially the same as storing clear-text versions of the passwords. For this reason, this policy must never be enabled..
 *
 * https://www.stigviewer.com/stig/windows_10/2019-01-04/finding/V-63429
 */

public class V_63429_Exercise extends PasswordPolicy {
    @Override
    public String checkTextCode() {
        return "C-64177r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63429";
    }

    @Override
    public String fixTextCode() {
        return "F-69357r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77919r1_rule";
    }

    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @Override
    public String severity() {
        return "High";
    }

    @Override
    public String version() {
        return "WN10-AC-000045";
    }

    @Override
    public String description() {
        return "Storing passwords using reversible encryption is essentially the same as storing clear-text versions of the passwords. For this reason, this policy must never be enabled.";
    }

    @Override
    protected String getCheckTextAdditional() {
        return "\nIf the value for \"Store password using reversible encryption\" is not set to \"Disabled\", this is a finding.\n" +
                "\n" +


    @Override
    protected String getFixTextAdditional() {
        return "";
    }

    @Override
    protected String getInclusionSetting() {
        return "Disabled";
    }

    @Override
    protected String getOption() {
        return "Store passwords using reversible encryption";
    }

    @Override
    protected Integer getCommandKey() {
        return 3;
    }

    @Override
    protected String getValueType() {
        return "PasswordReversibleEncryption";
    }
}
