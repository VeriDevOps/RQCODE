package rqcode.patterns.temporal;

import java.net.MalformedURLException;
import java.net.URL;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.concepts.Checkable;

/**
 * Temporal requirements pattern:
 * Globally, it is always the case that if P holds then, unless R holds, Q will eventually hold
 */
@objid ("cfe7df8b-4bc7-4e95-8a76-210c0dff2d22")
public class GlobalResponseUntil extends MonitoringLoop {
    @objid ("d7ad51d7-a5ac-4775-a8ad-f7d67988ee38")
    Checkable p;

    @objid ("a6c38d69-eaaa-4bd5-9c1d-cc28413cf7ed")
    Checkable q;

    @objid ("ed6f1fbc-64dd-45af-a899-9b55cb2b3887")
    Checkable r;

    @objid ("846c0d32-69a9-48a9-beb6-d20363aca577")
    public  GlobalResponseUntil(Checkable p, Checkable q, Checkable r) {
        this.p = p;
        this.q = q;
        this.r = r;
    }

    @objid ("7867c4d9-bdca-4039-b999-49c67430059c")
    @Override
    public boolean precondition() {
        return (r.check() == CheckStatus.FAIL) && (p.check() == CheckStatus.PASS);
    }

    @objid ("cb9d9f46-8349-4669-9e9d-93d0cf00b678")
    @Override
    public boolean exitCondition() {
        return (r.check() == CheckStatus.PASS) || (q.check() == CheckStatus.PASS);
    }

    @objid ("2028d15e-263e-4f09-b09f-8405b0227842")
    @Override
    public boolean postcondition() {
        if (q.check() == CheckStatus.FAIL) {
            Eventually eventuallyQ = new Eventually(q);
            return (eventuallyQ.check() == CheckStatus.PASS);
        }
        return true;
    }

    @objid ("825f816f-f65b-48c4-a19c-156cc6ef9126")
    @Override
    public String toString() {
        URL patternURL;
        try {
            patternURL = new URL("https://www.cse.msu.edu/~cse870/Materials/main-tech-report-security-patterns.pdf");
        } catch (MalformedURLException e) {
            return "";
        }
        return
                "Globally, it is always the case that if P holds then, unless R holds, Q will eventually hold (" +
                patternURL.toString() + "), where P is:\n\n\t\t" +
                        p.toString().replaceAll("\n", "\n\t\t") +
                "\nand R is:\n\n\t\t:" +
                        r.toString().replaceAll("\n", "\n\t\t") +
                "\nand Q is:\n\n\t\t:" +
                        q.toString().replaceAll("\n", "\n\t\t");
    }

    @objid ("19027b54-9d8e-4824-8a9f-10fd292f2ac5")
    @Override
    public String TCTL() {
        String qStr, rStr, pStr;
        if (q instanceof MonitoringLoop) {
            qStr = ((MonitoringLoop) q).TCTL();
        } else {
            qStr = q.getClass().getSimpleName();
        }
        if (r instanceof MonitoringLoop) {
            rStr = ((MonitoringLoop) r).TCTL();
        } else {
            rStr = r.getClass().getSimpleName();
        }
        if (p instanceof MonitoringLoop) {
            pStr = ((MonitoringLoop) p).TCTL();
        } else {
            pStr = p.getClass().getSimpleName();
        }
        return "AG ((" + pStr + ") ==> ((AF (" + qStr + ")) U (" + rStr + ")))";
    }

}
