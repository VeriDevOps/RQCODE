package rqcode.example;

public class Main {
    
    public static void main(String[] args) {
        Clock.tick();
        
        TickIncrementRequirement sr = new TickIncrementRequirement();
        TickBoundaryRequirement btr = new TickBoundaryRequirement();

        System.out.println(sr + "\n Check status: "+sr.check());

        Clock.seconds = 2;

        System.out.println(sr + "\n Check status: "+sr.check());

        Clock.seconds = -1;

        System.out.println(sr + "\n Check status: "+sr.check());

        Clock.seconds = -1;

        System.out.println(btr + "\n Check status: "+btr.check());        


    }
}
