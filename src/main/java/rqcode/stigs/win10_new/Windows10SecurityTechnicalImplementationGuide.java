package rqcode.stigs.win10_new;

import rqcode.stigs.win10_new.AuditPolicy.stigs.*;
import rqcode.stigs.win10_new.patterns.STIGPattern;

public class Windows10SecurityTechnicalImplementationGuide {
    public static final STIGPattern v_220752 = new V_220752();
     public static final STIGPattern v_220751 = new V_220751();
    public static void main(String[] args) {
       System.out.println(v_220752.check());
       System.out.println(v_220752.enforce());
       System.out.println(v_220752.check());
    }
}