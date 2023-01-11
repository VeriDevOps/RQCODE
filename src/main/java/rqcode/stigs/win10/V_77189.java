package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.AcrobatExploitProtectionRequirement;

/**
 * Exploit protection in Windows 10 provides a means of enabling additional mitigations against potential threats at the system and application level.
 * Without these additional application protections, Windows 10 may be subject to various exploits.
 *
 * https://www.stigviewer.com/stig/windows_10/2019-01-04/finding/V-77189
 */

public class V_77189 extends AcrobatExploitProtectionRequirement {
    @Override
    public String checkTextCode() {
        return "C-77241r8_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-77189";
    }

    @Override
    public String fixTextCode() {
        return "F-84325r4_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-91885r2_rule";
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
        return "WN10-EP-000070";
    }

    @Override
    public String description() {
        return "Exploit protection in Windows 10 provides a means of enabling additional mitigations against potential threats at the system and application level. Without these additional application protections, Windows 10 may be subject to various exploits.";
    }

    @Override
    protected Integer getCommandKey() {
        return 2;
    }
}
