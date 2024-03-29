package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.AccountLockoutPolicy;

/**
 *The account lockout feature, when enabled, prevents brute-force password attacks on the system.
 * The higher this value is, the less effective the account lockout feature will be in protecting the local system.
 * The number of bad logon attempts must be reasonably small to minimize the possibility of a successful password attack, while allowing for honest errors made during a normal user logon.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63409
 */

public class V_63409 extends AccountLockoutPolicy {
    @Override
    public String checkid() {
        return "C-64157r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String id() {
        return "V-63409";
    }

    @Override
    public String fixid() {
        return "F-69337r1_fix";
    }

    @Override
    public String iacontrols() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77899r1_rule";
    }

    @Override
    public String title(){
        return "Windows 10 Security Technical Implementation Guide";
    }

    @Override
    public String severity() {
        return "Medium";
    }

    @Override
    public String version() {
        return "WN10-AC-000010";
    }

    @Override
    public String description() {
        return "The account lockout feature, when enabled, prevents brute-force password attacks on the system. The higher this value is, the less effective the account lockout feature will be in protecting the local system. The number of bad logon attempts must be reasonably small to minimize the possibility of a successful password attack, while allowing for honest errors made during a normal user logon.";
    }

    @Override
    protected String getCheckTextAdditional() {
        return "\nIf the \"Account lockout threshold\" is \"0\" or more than \"3\" attempts, this is a finding.";
    }

    @Override
    protected String getFixTextAdditional() {
        return "  or less invalid logon attempts (excluding \"0\" which is unacceptable).";
    }

    @Override
    protected String getInclusionSetting() {
        return "3";
    }

    @Override
    protected String getOption() {
        return "Account lockout threshold";
    }

    @Override
    protected String getValueType() {
        return "LockoutBadCount";
    }
}
