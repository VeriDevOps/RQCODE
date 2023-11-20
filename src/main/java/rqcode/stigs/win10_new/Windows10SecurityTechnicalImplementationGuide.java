package rqcode.stigs.win10_new;

import rqcode.stigs.win10_new.AuditPolicy.stigs.*;
import rqcode.stigs.win10_new.RegistryEdit.stigs.V_220818;
import rqcode.stigs.win10_new.patterns.STIGPattern;

public class Windows10SecurityTechnicalImplementationGuide {
    public static final STIGPattern v_220752 = new V_220752();
    // public static final STIGPattern v_220751 = new V_220751();
    public static final STIGPattern v_220778 = new V_220778();
    public static final STIGPattern v_220818 = new V_220818();
    
    public static void main(String[] args) {
        System.out.println(v_220778.check());
        System.out.println(v_220778.enforce());
        System.out.println(v_220778.check());
    }
}