package rqcode.stigs.win10_new.patterns;

import rqcode.concepts.Checkable.CheckStatus;
import rqcode.concepts.Enforceable.EnforcementStatus;

public class STIGPatternMessage {
    public static String shortMessageCheck(STIGPattern pattern, CheckStatus checkStatus){
        String id = pattern.getPattern().getCheckValues().get("id");

        return "STIG " + id + "\nCheck status: " + checkStatus + "\n";
    }

    public static String shortMessageEnforce(STIGPattern pattern, EnforcementStatus enforcementStatus){
        String id = pattern.getPattern().getCheckValues().get("id");

        return "STIG " + id + "\nEnforce status: " + enforcementStatus + "\n";
    }

    public static String fullMessageCheck(STIGPattern pattern, CheckStatus checkStatus){
        String id = pattern.getPattern().getCheckValues().get("id");
        String description = pattern.getPattern().getAdditionalInfo().get("description");

        return "STIG " + id + " " + description + "\nCheck status: " + checkStatus + "\n";
    }

    public static String fullMessageEnforce(STIGPattern pattern, EnforcementStatus enforcementStatus){
        String id = pattern.getPattern().getCheckValues().get("id");
        String description = pattern.getPattern().getAdditionalInfo().get("description");

        return "STIG " + id + " " + description + "\nEnforce status: " + enforcementStatus + "\n";
    }
}
