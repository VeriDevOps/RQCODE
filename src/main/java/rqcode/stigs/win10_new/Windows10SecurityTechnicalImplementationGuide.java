package rqcode.stigs.win10_new;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_new.patterns.STIGPatternMessage;
import rqcode.stigs.win10_v3.UserRights.V_220969;
import rqcode.stigs.win10_v3.UserRights.V_220974;
import rqcode.stigs.win10_v3.UserRights.V_220975;
import rqcode.stigs.win10_v3.UserRights.V_220972;

public class Windows10SecurityTechnicalImplementationGuide {
    public static final STIG v_220969 = new V_220969();
    public static final STIG v_220974 = new V_220974();
    public static final STIG v_220975 = new V_220975();
    public static final STIG v_220972 = new V_220972();
    
    public static void main(String[] args) {
        System.out.println(STIGPatternMessage.shortMessageEnforce(v_220972, v_220972.enforce()));
        System.out.println(STIGPatternMessage.shortMessageCheck(v_220972, v_220972.check()));
        /*System.out.println(STIGPatternMessage.fullMessageEnforce(v_220975, v_220975.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220975, v_220975.check()));
        System.out.println(STIGPatternMessage.fullMessageEnforce(v_220968, v_220968.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220968, v_220968.check()));
        System.out.println(STIGPatternMessage.fullMessageEnforce(v_220870, v_220870.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220870, v_220870.check()));
        System.out.println(STIGPatternMessage.fullMessageEnforce(v_220871, v_220871.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220871, v_220871.check()));
        */


    }
}