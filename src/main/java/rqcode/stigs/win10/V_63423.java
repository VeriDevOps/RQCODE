package rqcode.stigs.win10;

import rqcode.patterns.win10.PasswordPolicy;

/**
 *Information systems not protected with strong password schemes (including passwords of minimum length) provide the opportunity for anyone to crack the password, thus gaining access to the system and compromising the device, information, or the local network.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63423
 */

public class V_63423 extends PasswordPolicy {
    @Override
    public String checkTextCode() {
        return "C-64171r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63423";
    }

    @Override
    public String fixTextCode() {
        return "F-69351r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77913r1_rule";
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
        return "WN10-AC-000035";
    }

    @Override
    public String description() {
        return "Information systems not protected with strong password schemes (including passwords of minimum length) provide the opportunity for anyone to crack the password, thus gaining access to the system and compromising the device, information, or the local network";
    }

    @Override
    protected String getCheckTextAdditional() {
        return "\nIf the value for the \"Minimum password length,\" is less than \"14\" characters, this is a finding.";
    }

    @Override
    protected String getFixTextAdditional() {
        return " characters.";
    }

    @Override
    protected String getInclusionSetting() {
        return "14";
    }

    @Override
    protected String getOption() {
        return "Minimum password length";
    }

    @Override
    protected Integer getCommandKey() {
        return 1;
    }

    @Override
    protected String getValueType() {
        return "MinimumPasswordLength";
    }
}
