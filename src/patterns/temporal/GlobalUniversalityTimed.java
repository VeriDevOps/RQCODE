package patterns.temporal;

import patterns.temporal.GlobalUniversality;
import stig.Checkable;

import java.net.MalformedURLException;
import java.net.URL;

public class GlobalUniversalityTimed extends GlobalUniversality {
    public GlobalUniversalityTimed(Checkable p, int boundary) {
        super(p);
        this.boundary = boundary;
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
                "Globally, it is always the case that P holds for at least " + this.boundary +
                " seconds (" + patternURL.toString() + "), where P is:\n\n\t\t" +
                        p.toString().replaceAll("\n", "\n\t\t");
    }

    @Override
    public String TCTL () {
        String pStr;
        if (p instanceof MonitoringLoop) {
            pStr = ((MonitoringLoop) p).TCTL();
        } else {
            pStr = p.getClass().getSimpleName();
        }
        return "AG >=" + this.boundary + " (" + pStr + ")";
    }
}
