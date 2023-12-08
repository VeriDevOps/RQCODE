package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.NoUserRightsAssignRequirement;

/**
 * Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.
 * Accounts with the "Create permanent shared objects" user right could expose sensitive data by creating shared objects.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63863
 */

public class V_63863 extends NoUserRightsAssignRequirement {
    @Override
    public String checkid() {
        return "C-64613r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String id() {
        return "V-63863";
    }

    @Override
    public String fixid() {
        return "F-69791r1_fix";
    }

    @Override
    public String iacontrols() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78353r1_rule";
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
        return "WN10-UR-000055";
    }

    @Override
    public String description() {
        return "Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the \"Create permanent shared objects\" user right could expose sensitive data by creating shared objects.";
    }

    @Override
    protected String getOption() {
        return "Create permanent shared objects";
    }

    @Override
    protected String getListAccountPrivilege() {
        return "SeCreatePermanentPrivilege";
    }
}

