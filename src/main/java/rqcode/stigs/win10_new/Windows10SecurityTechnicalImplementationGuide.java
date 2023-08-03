package rqcode.stigs.win10_new;

import rqcode.stigs.win10_new.AuditPolicy.stigs.V_63447;
import rqcode.stigs.win10_new.AuditPolicy.stigs.V_63449;
import rqcode.stigs.win10_new.AuditPolicy.stigs.V_63463;
import rqcode.stigs.win10_new.AuditPolicy.stigs.V_63467;
import rqcode.stigs.win10_new.RegistryEdit.stigs.V_63321;
import rqcode.stigs.win10_new.RegistryEdit.stigs.V_63647;
import rqcode.stigs.win10_new.RegistryEdit.stigs.V_63703;
import rqcode.stigs.win10_new.RegistryEdit.stigs.V_63709;
import rqcode.stigs.win10_new.patterns.STIGPattern;

public class Windows10SecurityTechnicalImplementationGuide {
    public static final STIGPattern v_63447 = new V_63447();
    public static final STIGPattern v_63449 = new V_63449();
    public static final STIGPattern v_63463 = new V_63463();
    public static final STIGPattern v_63467 = new V_63467();
    public static final STIGPattern v_63709 = new V_63709();

    public static final STIGPattern v_63703 = new V_63703();

    public static final STIGPattern v_63321 = new V_63321();

    public static final STIGPattern v_63647 = new V_63647();

    public static void main(String[] args) {
        System.out.println(v_63447.check());
        System.out.println(v_63449.check());
        System.out.println(v_63463.check());
        System.out.println(v_63467.check());
        System.out.println(v_63709.check());
        System.out.println(v_63703.check());
        System.out.println(v_63321.check());
        System.out.println(v_63647.check());
    }
}