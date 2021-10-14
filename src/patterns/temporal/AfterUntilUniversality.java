package patterns.temporal;

import stig.Checkable;

import java.net.MalformedURLException;
import java.net.URL;

public class AfterUntilUniversality implements MonitoringLoop {
    private Checkable q, p, r;

    public AfterUntilUniversality(Checkable q, Checkable p, Checkable r) {
        this.q = q;
        this.p = p;
        this.r = r;
    }

    @Override
    public boolean precondition() {
        return (q.check() == CheckStatus.PASS);
    }

    @Override
    public boolean invariant() {
        return (p.check() == CheckStatus.PASS || exitCondition());
    }

    @Override
    public boolean exitCondition() {
        return (r.check() == CheckStatus.PASS);
    }

    @Override
    public String toString() {
        URL patternURL;
        try {
            patternURL = new URL("https://people.cs.ksu.edu/~dwyer/SPAT/ctl.html#Universality");
        } catch (MalformedURLException e) {
            return "";
        }
        return
                "After Q, it is always the case that P holds until R holds (" + patternURL.toString() + "), where Q is:\n\n\t\t" +
                        q.toString().replaceAll("\n", "\n\t\t") +
                "and P is:\n\n\t\t:" +
                        p.toString().replaceAll("\n", "\n\t\t") +
                "and R is:\n\n\t\t:" +
                        r.toString().replaceAll("\n", "\n\t\t");
    }

    @Override
    public String TCTL() {
        return "AG(Q ==> !E[!R U (!P & !R)])";
    }
}
