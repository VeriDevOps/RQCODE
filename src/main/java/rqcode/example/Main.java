package rqcode.example;

public class Main {
    
    public static void main(String[] args) {
        Clock.tick();
        
        SecondsRequirement sr = new SecondsRequirement();
        System.out.println(sr + "\n Check status: "+sr.check());

        Clock.seconds = -1;

        System.out.println(sr + "\n Check status: "+sr.check());


    }
}
