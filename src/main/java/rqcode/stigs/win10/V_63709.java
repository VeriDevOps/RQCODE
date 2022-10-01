package rqcode.stigs.win10;

import rqcode.patterns.win10.SoftwareRegEditRequirement;

/**
 * Passwords save locally for re-use when browsing may be subject to compromise.
 * Disabling the Edge password manager will prevent this for the browser.
 *
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63709
 */

public class V_63709 extends SoftwareRegEditRequirement {
    @Override
    public String checkTextCode() {
        return "C-79113r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63709";
    }

    @Override
    public String fixTextCode() {
        return "F-83245r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78199r4_rule";
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
        return "WN10-CC-000245";
    }

    @Override
    public String description() {
        return "Passwords save locally for re-use when browsing may be subject to compromise. Disabling the Edge password manager will prevent this for the browser.";
    }

    @Override
    protected String getRegistryPath() {
        return "\\SOFTWARE\\Policies\\Microsoft\\MicrosoftEdge\\Main\\";
    }

    @Override
    protected String getValueName() {
        return "FormSuggest Passwords";
    }

    @Override
    protected String getValueType() {
        return "REG_SZ";
    }

    @Override
    protected String getValue() {
        return "no";
    }

    @Override
    protected String getOption() {
        return "Configure Password Manager";
    }

    @Override
    public String getCheckTextAdditional() {
        return "Windows 10 LTSC\\B versions do not include Microsoft Edge, this is NA for those systems.\n";
    }

    @Override
    public String getComponentName() {
        return "Microsoft Edge";
    }
}
