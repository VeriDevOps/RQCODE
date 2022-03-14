package rqcode.stigs.ubuntu;

import rqcode.stigs.ubuntu.V_219157.V_219157;
import rqcode.stigs.ubuntu.V_219158.V_219158;
import rqcode.stigs.ubuntu.V_219161.V_219161;
import rqcode.stigs.ubuntu.V_219177.V_219177;
import rqcode.stigs.ubuntu.V_219304.V_219304;


public class Main {
    public static void main(String[] args) {
        Package testCheck = new Package("asdf", true);
        System.out.println(testCheck.check().toString());
        V_219157 v_219157 = new V_219157();
        System.out.println(v_219157.toString());
        System.out.println(v_219157.check());
        V_219158 v_219158 = new V_219158();
        System.out.println(v_219158.toString());       
        System.out.println(v_219158.check());    
        V_219161 v_219161 = new V_219161();
        System.out.println(v_219161.toString());       
        System.out.println(v_219161.check());      
        V_219177 v_219177 = new V_219177();
        System.out.println(v_219177);       
        System.out.println(v_219177.check()); 
        V_219304 v_219304 = new V_219304();
        System.out.println(v_219304);       
        System.out.println(v_219304.check());  
    }
}
