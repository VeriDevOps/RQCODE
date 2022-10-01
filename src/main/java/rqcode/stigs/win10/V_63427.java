package rqcode.stigs.win10;

import rqcode.patterns.win10.PasswordPolicy;

/**
 *The use of complex passwords increases their strength against guessing and brute-force attacks.
 * This setting configures the system to verify that newly created passwords conform to the Windows password complexity policy.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63427
 */

public class V_63427 extends PasswordPolicy {
    @Override
    public String checkTextCode() {
        return "C-64175r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63427";
    }

    @Override
    public String fixTextCode() {
        return "F-69355r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77917r1_rule";
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
        return "WN10-AC-000040";
    }

    @Override
    public String description() {
        return "The use of complex passwords increases their strength against guessing and brute-force attacks. This setting configures the system to verify that newly created passwords conform to the Windows password complexity policy.";
    }

    @Override
    protected String getCheckTextAdditional() {
        return "\nIf the value for \"Password must meet complexity requirements\" is not set to \"Enabled\", this is a finding.\n" +
                "\n" +
                "If the site is using a password filter that requires this setting be set to \"Disabled\" for the filter to be used, this would not be considered a finding.";
    }

    @Override
    protected String getFixTextAdditional() {
        return "";
    }

    @Override
    protected String getInclusionSetting() {
        return "Enabled";
    }

    @Override
    protected String getOption() {
        return "Password must meet complexity requirements";
    }

    @Override
    protected Integer getCommandKey() {
        return 2;
    }

    @Override
    protected String getValueType() {
        return "PasswordComplexity";
    }
}
