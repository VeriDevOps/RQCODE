package rqcode.stigs.win10;



import rqcode.stigs.win10.patterns.SensitivePrivilegeUseRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Sensitive Privilege Use records events related to use of sensitive privileges, such as "Act as part of the operating system" or "Debug programs".
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63487
 */

public class V_63487 extends SensitivePrivilegeUseRequirement {
    
    @Override
    protected String getFailure() {
        return null;
    }

    
    @Override
    protected String getInclusionSetting() {
        return "Success";
    }

    
    @Override
    protected String getSuccess() {
        return "enable";
    }

    
    @Override
    public String checkid() {
        return "C-64237r1_chk";
    }

    
    @Override
    public String date() {
        return "2020-06-15";
    }

    
    @Override
    public String id() {
        return "V-63487";
    }

    
    @Override
    public String fixid() {
        return "F-69417r1_fix";
    }

    
    @Override
    public String iacontrols() {
        return "";
    }

    
    @Override
    public String ruleID() {
        return "SV-77977r1_rule";
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
        return "WN10-AU-000115";
    }

}
