package rqcode.stigs.win10_new;

import rqcode.stigs.win10_new.AuditPolicy.stigs.*;
import rqcode.stigs.win10_new.RegistryEdit.stigs.*;
import rqcode.stigs.win10_new.patterns.STIGPattern;

public class Windows10SecurityTechnicalImplementationGuide {
    public static final STIGPattern v_63447 = new V_63447();
    public static void main(String[] args) {
        System.out.println(v_63447.check());

    }
}