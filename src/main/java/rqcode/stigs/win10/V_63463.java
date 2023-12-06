package rqcode.stigs.win10;



import java.util.Map;

import rqcode.stigs.win10.patterns.LogonRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed.
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63463
 */

public class V_63463 extends LogonRequirement {
    

    @Override
    protected String getFailure() {
        return "enable";
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
    public String checkid() {
        return "C-64211r1_chk";
    }

    
    @Override
    public String date() {
        return "2020-06-15";
    }

    
    @Override
    public String id() {
        return "V-63463";
    }

    
    @Override
    public String fixid() {
        return "F-69391r1_fix";
    }

    
    @Override
    public String iacontrols() {
        return "";
    }

    
    @Override
    public String ruleID() {
        return "SV-77953r1_rule";
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
        return "WN10-AU-000070";
    }

}
