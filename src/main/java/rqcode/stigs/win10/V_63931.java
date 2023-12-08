package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.AvailableUserRightsAssignRequirement;

/**
 * Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.
 * Accounts with the "Modify firmware environment values" user right can change hardware configuration environment variables.
 * This could result in hardware failures or a DoS.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63931
 */

public class V_63931 extends AvailableUserRightsAssignRequirement {
    @Override
    public String checkid() {
        return "C-64681r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String id() {
        return "V-63931";
    }

    @Override
    public String fixid() {
        return "F-69859r1_fix";
    }

    @Override
    public String iacontrols() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78421r1_rule";
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
        return "WN10-UR-000140";
    }

    @Override
    public String description() {
        return "Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the \"Modify firmware environment values\" user right can change hardware configuration environment variables. This could result in hardware failures or a DoS.";
    }

    @Override
    protected String getInclusionSetting() {
        return "Administrators";
    }

    @Override
    public String getOption() {
        return "Modify firmware environment values";
    }

    @Override
    protected String getListAccountPrivilege() {
        return "SeInteractiveLogonRight";
    }

    @Override
    protected String getGrantUserRights() {
        return "Grant-UserRight 'S-1-5-32-544' " + getListAccountPrivilege();
    }
}

