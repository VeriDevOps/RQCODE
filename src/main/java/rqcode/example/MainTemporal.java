package rqcode.example;

import rqcode.temporal_patterns.GlobalUniversalityTimed;

public class MainTemporal {
    public static void main(String[] args) {
        SecondsRequirement sr = new SecondsRequirement();
        /**
         * timed seconds requirement to hold till specific time
         */
        GlobalUniversalityTimed tsr = new GlobalUniversalityTimed(sr, Integer.MAX_VALUE);

        System.out.println (tsr + "\nCheck status:"+tsr.check());        
    }
}
