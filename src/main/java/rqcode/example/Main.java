package rqcode.example;

public class Main {
    
    public static void main(String[] args) {
        Clock.tick();
        
        TickRequirement sr = new TickRequirement();
        BetterTickRequirement btr = new BetterTickRequirement();

        System.out.println(sr + "\n Check status: "+sr.check());

        Clock.seconds = 2;

        System.out.println(sr + "\n Check status: "+sr.check());

        Clock.seconds = -1;

        System.out.println(sr + "\n Check status: "+sr.check());

        Clock.seconds = -1;

        System.out.println(btr + "\n Check status: "+btr.check());        


    }
}
