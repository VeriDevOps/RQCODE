package rqcode.stigs.win10;

import rqcode.patterns.win10.SystemRegEditRequirement;

public class V_63703 extends SystemRegEditRequirement {
    @Override
    public String checkTextCode() {
        return "C-64451r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63703";
    }

    @Override
    public String fixTextCode() {
        return "F-69629r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78193r1_rule";
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
