package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.SoftwareRegEditRequirement;

/**
 * Installation options for applications are typically controlled by administrators. This setting prevents users from changing installation options that may bypass security features.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63321
 */

public class V_63321 extends SoftwareRegEditRequirement {
    @Override
    public String checkid() {
        return "C-64055r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String id() {
        return "V-63321";
    }

    @Override
    public String fixid() {
        return "F-69239r1_fix";
    }

    @Override
    public String iacontrols() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77811r1_rule";
    }

    @Override
    public String title() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @Override
    public String severity() {
        return "Medium";
    }

    @Override
    public String version() {
        return "WN10-CC-000310";
    }

    @Override
    public String description() {
        return "Installation options for applications are typically controlled by administrators. This setting prevents users from changing installation options that may bypass security features.";
    }

    @Override
    protected String getRegistryPath() {
        return "\\SOFTWARE\\Policies\\Microsoft\\Windows\\Installer\\";
    }

    @Override
    protected String getValueName() {
        return "EnableUserControl";
    }

    @Override
    protected String getValueType() {
        return "REG_DWORD";
    }

    @Override
    protected String getValue() {
        return "0";
    }

    @Override
    protected String getOption() {
        return "Allow user control over installs";
    }

    @Override
    public String getCheckTextAdditional() {
        return "";
    }

    @Override
    public String getComponentName() {
        return "Windows Installer";
    }
}
