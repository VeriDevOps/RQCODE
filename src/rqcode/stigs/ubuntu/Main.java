package rqcode.stigs.ubuntu;

import rqcode.concepts.Checkable.CheckStatus;
import rqcode.stigs.ubuntu.V_219157.V_219157;
import rqcode.stigs.ubuntu.V_219158.V_219158;

public class Main {
    public static void main(String[] args) {
        Package testCheck = new Package("asdf", true);
        CheckStatus result = testCheck.check();
        System.out.println(result.toString());
        V_219157 v_219157 = new V_219157();
        System.out.println(v_219157.check().toString());
        V_219158 v_219158 = new V_219158();
        System.out.println(v_219158.check().toString());        
    }
}
