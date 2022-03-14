package rqcode.patterns.temporal;

import rqcode.concepts.Checkable;

import java.net.MalformedURLException;
import java.net.URL;

public class GlobalResponseUntil extends MonitoringLoop {
    Checkable p, q, r;

    public GlobalResponseUntil(Checkable p, Checkable q, Checkable r) {
        this.p = p;
        this.q = q;
        this.r = r;
    }

    @Override
    public boolean precondition() {
        return (r.check() == CheckStatus.FAIL) && (p.check() == CheckStatus.PASS);
    }

    @Override
    public boolean exitCondition() {
        return (r.check() == CheckStatus.PASS) || (q.check() == CheckStatus.PASS);
    }

    @Override
    public boolean postcondition() {
        if (q.check() == CheckStatus.FAIL) {
            Eventually eventuallyQ = new Eventually(q);
            return (eventuallyQ.check() == CheckStatus.PASS);
        }
        return true;
    }

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
