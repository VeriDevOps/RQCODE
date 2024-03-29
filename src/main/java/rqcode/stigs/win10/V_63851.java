package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.AvailableUserRightsAssignRequirement;

/**
 * Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.
 * Accounts with the "Allow log on locally" user right can log on interactively to a system.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63851
 */


public class V_63851 extends AvailableUserRightsAssignRequirement {
    @Override
    public String checkid() {
        return "C-81367r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String id() {
        return "V-63851";
    }

    @Override
    public String fixid() {
        return "F-88439r1_fix";
    }

    @Override
    public String iacontrols() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78341r2_rule";
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
        return "WN10-UR-000025";
    }

    @Override
    public String description() {
        return "Inappropriate granting of user rights can provide system, administrative, and other high-level capabilities. Accounts with the \"Allow log on locally\" user right can log on interactively to a system.";
    }

    @Override
    protected String getOption() {
        return "Allow log on locally";
    }

    @Override
    public String getInclusionSetting() {
        return "Administrators\n" +
                "Users";
    }

    @Override
    protected String getListAccountPrivilege() {
        return "SeInteractiveLogonRight";
    }

    @Override
    protected String getGrantUserRights() {
        return "Grant-UserRight 'S-1-5-32-544'" + getListAccountPrivilege() +
                "\nGrant-UserRight 'S-1-5-32-545'" + getListAccountPrivilege();
    }
}

