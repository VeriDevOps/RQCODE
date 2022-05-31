import rqcode.concepts.Checkable;
import rqcode.stigs.win10.Windows10SecurityTechnicalImplementationGuide;

public class SimpleTest {

    public static void main (String[] args) {
        for (Checkable r : Windows10SecurityTechnicalImplementationGuide.allSTIGs()) {
            r.check();

        }
    }
}
