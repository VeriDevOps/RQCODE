package rqcode.stigs.win10;



import rqcode.stigs.win10.patterns.UserAccountManagementRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63447
 */

public class V_63447 extends UserAccountManagementRequirement {
    
    @Override
    public String id() {
        return "V-63447";
    }

    
    @Override
    public String version() {
        return "WN10-AU-000035";
    }

    
    @Override
    public String ruleID() {
        return "SV-77937r1_rule";
    }

    
    @Override
    public String iacontrols() {
        return "";
    }

    
    @Override
    public String severity() {
        return "Medium";
    }

    
    @Override
    public String title(){
        return "Windows 10 Security Technical Implementation Guide";
    }

    
    @Override
    public String date() {
        return "2020-06-15";
    }

    
    @Override
    public String checkid() {
        return "C-64195r1_chk";
    }

    
    @Override
    public String fixid() {
        return "F-69375r1_fix";
    }

    
    @Override
    protected String getInclusionSetting() {
        return "Failure";
    }

    
    @Override
    protected String getSuccess() {
        return null;
    }

    
    @Override
    protected String getFailure() {
        return "enable";
    }

}
