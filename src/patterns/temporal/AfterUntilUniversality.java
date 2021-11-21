package patterns.temporal;

import rqcode.concepts.Checkable;

import java.net.MalformedURLException;
import java.net.URL;

public class AfterUntilUniversality extends MonitoringLoop {
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
                "\nand P is:\n\n\t\t:" +
                        p.toString().replaceAll("\n", "\n\t\t") +
                "\nand R is:\n\n\t\t:" +
                        r.toString().replaceAll("\n", "\n\t\t");
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
        return "AG((" + qStr + "==> !E[!(" + rStr + ") U (!(" + pStr +") & !(" + rStr + "))])";
    }
}
