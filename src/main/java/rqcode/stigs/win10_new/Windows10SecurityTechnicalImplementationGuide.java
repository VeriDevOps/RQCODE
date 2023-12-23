package rqcode.stigs.win10_new;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_new.AuditPolicy.stigs.*;
import rqcode.stigs.win10_new.RegistryEdit.stigs.V_220818;
import rqcode.stigs.win10_new.RegistryEdit.stigs.V_250318;
import rqcode.stigs.win10_new.patterns.STIGPattern;
import rqcode.stigs.win10_new.patterns.STIGPatternMessage;
import rqcode.stigs.win10_v3.AuditPolicy.V_220752;
import rqcode.stigs.win10_v3.AuditPolicy.V_220778;

public class Windows10SecurityTechnicalImplementationGuide {
    //public static final STIGPattern v_220752 = new V_220752();
    // public static final STIG v_220751 = new V_220751();
    public static final STIG v_220778 = new V_220778();
    //public static final STIGPattern v_220818 = new V_220818();
    //public static final STIGPattern v_250318 = new V_250318();
    
    public static void main(String[] args) {
         System.out.println(STIGPatternMessage.fullMessageEnforce(v_220778, v_220778.enforce()));
        System.out.println(STIGPatternMessage.fullMessageCheck(v_220778, v_220778.check()));
       // System.out.println(STIGPatternMessage.fullMessageEnforce(v_220818, v_220818.enforce()));
      //  System.out.println(STIGPatternMessage.fullMessageCheck(v_220752, v_220752.check()));
    }
}