package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.SystemRegEditRequirement;

/**
 * Requests sent on the secure channel are authenticated, and sensitive information (such as passwords) is encrypted, but the channel is not integrity checked.
 * If this policy is enabled, outgoing secure channel traffic will be signed.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63647
 */

public class V_63647 extends SystemRegEditRequirement {
    @Override
    public String checkid() {
        return "C-64397r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String id() {
        return "V-63647";
    }

    @Override
    public String fixid() {
        return "F-69577r1_fix";
    }

    @Override
    public String iacontrols() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78137r1_rule";
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
        return "WN10-SO-000045";
    }

    @Override
    public String description() {
        return "Requests sent on the secure channel are authenticated, and sensitive information (such as passwords) is encrypted, but the channel is not integrity checked. If this policy is enabled, outgoing secure channel traffic will be signed.";
    }

    @Override
    public String getValueName() {
        return "SignSecureChannel";
    }

    @Override
    protected String getRegistryPath() {
        return "\\SYSTEM\\CurrentControlSet\\Services\\Netlogon\\Parameters\\";
    }

    @Override
    protected String getOption() {
        return "Domain member: Digitally sign secure channel data (when possible)";
    }
}

