package rqcode.example;

public class MainTemporal {
    public static void main(String[] args) {
        /**
         * The tick increment requirement is to hold for 10 seconds
         */
        TimedTickRequirement ttr = new TimedTickRequirement();

        System.out.println (ttr + "\nCheck status:"+ttr.check());     
    }
}
