package rqcode.example;

import rqcode.temporal_patterns.GlobalUniversalityTimed;

public class MainTemporal {
    public static void main(String[] args) {
        SecondsRequirement sr = new SecondsRequirement();
        /**
         * timed seconds requirement to hold 10 seconds
         */
        GlobalUniversalityTimed tsr = new GlobalUniversalityTimed(sr, 10);

        System.out.println (tsr + "\nCheck status:"+tsr.check());     
    }
}
