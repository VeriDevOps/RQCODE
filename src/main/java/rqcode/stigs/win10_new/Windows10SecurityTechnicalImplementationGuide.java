package rqcode.stigs.win10_new;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_new.patterns.STIGPatternMessage;
import rqcode.stigs.win10_v3.RegEdit.V_250318;
import rqcode.stigs.win10_v3.AuditPolicy.V_220778;
import rqcode.stigs.win10_v3.UserRights.V_220969;
import rqcode.stigs.win10_v3.UserRights.V_220970;
import rqcode.stigs.win10_v3.UserRights.V_220971;

public class Windows10SecurityTechnicalImplementationGuide {
    // public static final STIG v_220751 = new V_220751();
    public static final STIG v_220778 = new V_220778();
    public static final STIG v_250318 = new V_250318();
    public static final STIG v_220969 = new V_220969();
    public static final STIG v_220970 = new V_220970();
    public static final STIG v_220971 = new V_220971();
    
    public static void main(String[] args) {
        // System.out.println(STIGPatternMessage.fullMessageEnforce(v_220778, v_220778.enforce()));
        //System.out.println(STIGPatternMessage.fullMessageCheck(v_220778, v_220778.check()));
       // System.out.println(STIGPatternMessage.fullMessageEnforce(v_250318, v_250318.enforce()));
       // System.out.println(STIGPatternMessage.fullMessageCheck(v_250318, v_250318.check()));
       System.out.println(STIGPatternMessage.fullMessageEnforce(v_220969, v_220969.enforce()));
       System.out.println(STIGPatternMessage.fullMessageCheck(v_220969, v_220969.check()));
       System.out.println(STIGPatternMessage.fullMessageEnforce(v_220970, v_220970.enforce()));
       System.out.println(STIGPatternMessage.fullMessageCheck(v_220970, v_220970.check()));
       System.out.println(STIGPatternMessage.fullMessageEnforce(v_220971, v_220971.enforce()));
       System.out.println(STIGPatternMessage.fullMessageCheck(v_220971, v_220971.check()));

    }
}