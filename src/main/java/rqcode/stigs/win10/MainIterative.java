package rqcode.stigs.win10;

import rqcode.stigs.STIG;

public class MainIterative {
    /**
     * @param args
     */
    public static void main(String[] args) {
        STIG[] allSTIGs = Windows10SecurityTechnicalImplementationGuide.allSTIGs();

        for (STIG stig : allSTIGs){
             System.out.println(stig.check());
        }
        
    }
}
