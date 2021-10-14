package patterns.temporal;

import stig.Checkable;

import java.net.MalformedURLException;
import java.net.URL;

public class GlobalResponse implements MonitoringLoop {
    private Checkable s, r;

    public GlobalResponse(Checkable s, Checkable r) {
        this.s = s;
        this.r = r;
    }

    @Override
    public boolean precondition() {
        return (s.check() == CheckStatus.PASS);
    }

    @Override
    public boolean postcondition() {
        return (r.check() == CheckStatus.PASS);
    }

    @Override
    public boolean exitCondition() {
        return (r.check() == CheckStatus.PASS);
    }

    @Override
    public boolean timed() {
        return true;
    }

    @Override
    public String toString() {
        URL patternURL;
        try {
            patternURL = new URL("https://people.cs.ksu.edu/~dwyer/SPAT/ctl.html#Response");
        } catch (MalformedURLException e) {
            return "";
        }
        return
                "Globally, it is always the case that if S holds, the R will eventually hold within " + boundary() +
                " seconds (" + patternURL.toString() + "), where S is:\n\n\t\t" +
                        s.toString().replaceAll("\n", "\n\t\t") +
                "and R is:\n\n\t\t:" +
                        r.toString().replaceAll("\n", "\n\t\t");
    }

    @Override
    public String TCTL() {
        return "AG(S ==> AF <= " + boundary() + " (R))";
    }
}
