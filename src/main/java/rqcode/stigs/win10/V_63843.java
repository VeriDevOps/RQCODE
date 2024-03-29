package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.NoUserRightsAssignRequirement;

/**
 * Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.
 * Accounts with the "Access Credential Manager as a trusted caller" user right may be able to retrieve the credentials of other accounts from Credential Manager.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63843
 */

public class V_63843 extends NoUserRightsAssignRequirement {
    @Override
    public String checkid() {
        return "C-64593r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String id() {
        return "V-63843";
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
        return "Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the \"Access Credential Manager as a trusted caller\" user right may be able to retrieve the credentials of other accounts from Credential Manager.";
    }

    @Override
    protected String getOption() {
        return "Access Credential Manager as a trusted caller";
    }

    @Override
    protected String getListAccountPrivilege() {
        return "SeTrustedCredManAccessPrivilege";
    }
}

