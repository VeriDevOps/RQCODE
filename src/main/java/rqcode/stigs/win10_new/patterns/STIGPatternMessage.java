package rqcode.stigs.win10_new.patterns;

import rqcode.concepts.Checkable.CheckStatus;
import rqcode.concepts.Enforceable.EnforcementStatus;
import rqcode.stigs.STIG;

public class STIGPatternMessage {
    public static String shortMessageCheck(STIGPattern pattern, CheckStatus checkStatus){
        String id = pattern.getPattern().getCheckValues().get("id");

        return "STIG " + id + "\nCheck status: " + checkStatus + "\n";
    }

    public static String shortMessageEnforce(STIGPattern pattern, EnforcementStatus enforcementStatus){
        String id = pattern.getPattern().getCheckValues().get("id");

        return "STIG " + id + "\nEnforce status: " + enforcementStatus + "\n";
    }

    public static String fullMessageCheck(STIG stig, CheckStatus checkStatus)
    {   
        String id = stig.id();
        String date = stig.date();
        String severity = stig.severity();
        String version = stig.version();
        String ruleID = stig.ruleID();
        String title = stig.title();
        String checktext = stig.checktext();
        String checkid = stig.checkid();
        String description = stig.description();
        String fixtext = stig.fixtext();
        String fixid = stig.fixid();
        String iacontrols = stig.iacontrols();


         return "STIG " + id + " " + title + "\nCheck status: " + checkStatus + "\nDescription: " + description +
         "\nSeverity: " + severity + "\nDate: " + date + "\nVersion: " + version +
         "\nRuleID: " + ruleID + "\nCheckText: " + checktext + "\nCheckid: " + checkid + "\nFixtext: " + fixtext +
         "\nFixid: " + fixid + "\nIacontrols: " + iacontrols;
    }

    public static String fullMessageEnforce(STIG stig, EnforcementStatus enforcementStatus){
        String id = stig.id();
        String date = stig.date();
        String severity = stig.severity();
        String version = stig.version();
        String ruleID = stig.ruleID();
        //String parameter = stig.parameter();
        String title = stig.title();
        String checktext = stig.checktext();
        String checkid = stig.checkid();
        String description = stig.description();
        String fixtext = stig.fixtext();
        String fixid = stig.fixid();
        String iacontrols = stig.iacontrols();

        

        return "STIG " + id + " " + title + "\nEnforce status: " + enforcementStatus + "\nDescription: " + description +
         "\nSeverity: " + severity + "\nDate: " + date + "\nVersion: " + version +
         "\nRuleID: " + ruleID + "\nCheckText: " + checktext + "\nCheckid: " + checkid + "\nFixtext: " + fixtext +
         "\nFixid: " + fixid + "\nIacontrols: " + iacontrols;
    }
}
