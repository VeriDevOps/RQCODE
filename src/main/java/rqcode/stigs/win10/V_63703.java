package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.SystemRegEditRequirement;

/**
 * The server message block (SMB) protocol provides the basis for many network operations.
 * Digitally signed SMB packets aid in preventing man-in-the-middle attacks.
 * If this policy is enabled, the SMB client will only communicate with an SMB server that performs SMB packet signing.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63703
 */

public class V_63703 extends SystemRegEditRequirement {
    @Override
    public String checkid() {
        return "C-64451r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String id() {
        return "V-63703";
    }

    @Override
    public String fixid() {
        return "F-69629r1_fix";
    }

    @Override
    public String iacontrols() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78193r1_rule";
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
        return "WN10-SO-000100";
    }

    @Override
    public String description() {
        return "The server message block (SMB) protocol provides the basis for many network operations. Digitally signed SMB packets aid in preventing man-in-the-middle attacks. If this policy is enabled, the SMB client will only communicate with an SMB server that performs SMB packet signing.";
    }

    @Override
    public String getValueName() {
        return "RequireSecuritySignature";
    }

    @Override
    protected String getRegistryPath() {
        return "\\SYSTEM\\CurrentControlSet\\Services\\LanmanWorkstation\\Parameters\\";
    }

    @Override
    protected String getOption() {
        return "Microsoft network client: Digitally sign communications (always)";
    }
}
