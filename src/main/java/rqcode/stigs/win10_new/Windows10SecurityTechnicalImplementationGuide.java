package rqcode.stigs.win10_new;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_new.patterns.STIGPatternMessage;
import rqcode.stigs.win10_v3.UserRights.V_220969;
import rqcode.stigs.win10_v3.UserRights.V_220982;
import rqcode.stigs.win10_v3.UserRights.V_220975;
import rqcode.stigs.win10_v3.UserRights.V_220968;
import rqcode.stigs.win10_v3.RegEdit.V_220870;
import rqcode.stigs.win10_v3.RegEdit.V_220871;


public class Windows10SecurityTechnicalImplementationGuide {
    public static final STIG v_220969 = new V_220969();
    public static final STIG v_220982 = new V_220982();
    public static final STIG v_220975 = new V_220975();
    public static final STIG v_220968 = new V_220968();
    public static final STIG v_220870 = new V_220870();
    public static final STIG v_220871 = new V_220871();

    
    public static void main(String[] args) {
        System.out.println(STIGPatternMessage.fullMessageEnforce(v_220969, v_220969.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220969, v_220969.check()));
        System.out.println(STIGPatternMessage.fullMessageEnforce(v_220982, v_220982.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220982, v_220982.check()));
        System.out.println(STIGPatternMessage.fullMessageEnforce(v_220975, v_220975.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220975, v_220975.check()));
        System.out.println(STIGPatternMessage.fullMessageEnforce(v_220968, v_220968.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220968, v_220968.check()));
        System.out.println(STIGPatternMessage.fullMessageEnforce(v_220870, v_220870.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220870, v_220870.check()));
        System.out.println(STIGPatternMessage.fullMessageEnforce(v_220871, v_220871.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220871, v_220871.check()));


    }
}