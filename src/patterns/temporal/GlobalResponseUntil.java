package patterns.temporal;

import stig.Checkable;

import java.net.MalformedURLException;
import java.net.URL;

public class GlobalResponseUntil implements MonitoringLoop {
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
    public String TCTL() {
        return "AG (P ==> ((AF (Q)) U R))";
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
                "and R is:\n\n\t\t:" +
                        r.toString().replaceAll("\n", "\n\t\t") +
                "and Q is:\n\n\t\t:" +
                        q.toString().replaceAll("\n", "\n\t\t");
    }
}
