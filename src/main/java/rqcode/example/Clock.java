package rqcode.example;

/**
 * Example adapted from https://www.sciencedirect.com/science/article/abs/pii/S1477842416301981
 * 
 * For simplicity reasons all attributes and methods are static.
 */

public class Clock {

    public static int seconds = 0;

    /**
     * increment clock seconds by 1 at each tick
     */
    public static void tick(){
        if (seconds<60) {
            seconds++;
        } else {
            seconds = 0;
        }
    }
}
