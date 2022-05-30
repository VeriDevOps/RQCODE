package test.java;

import main.java.rqcode.concepts.Checkable;
import main.java.rqcode.stigs.win10.Windows10SecurityTechnicalImplementationGuide;

public class SimpleTest {

    public static void main (String[] args) {
        for (Checkable r : Windows10SecurityTechnicalImplementationGuide.allSTIGs()) {
            r.check();

        }
    }
}
