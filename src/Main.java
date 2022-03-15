import rqcode.stigs.win10.V_63467;
import rqcode.patterns.temporal.GlobalResponseTimed;
import rqcode.patterns.temporal.GlobalUniversalityTimed;
import rqcode.stigs.win10.V_63449;

public class Main {
    public static void main(String[] args) {
        V_63449 v_63449 = new V_63449();
        GlobalUniversalityTimed globalUniversality_V_63449 = new GlobalUniversalityTimed(v_63449, Integer.MAX_VALUE);
        V_63467 v_63467 = new V_63467();
        GlobalResponseTimed globalResponseTimed_V_63449_V_63447 =
                new GlobalResponseTimed(v_63449, v_63467, Integer.MAX_VALUE);
        GlobalResponseTimed globalResponseTimedComposed =
                new GlobalResponseTimed(globalUniversality_V_63449, globalResponseTimed_V_63449_V_63447, Integer.MAX_VALUE);

        System.out.println(globalResponseTimedComposed);
        System.out.println(globalResponseTimedComposed.TCTL());
        System.out.println (globalUniversality_V_63449.check());
    }
}
