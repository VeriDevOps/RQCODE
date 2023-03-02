package rqcode.temporal_patterns;

import java.net.MalformedURLException;
import java.net.URL;


import rqcode.concepts.Checkable;

/**
 * Temporal requirements pattern:
 * Globally, Universally: Globally, it is always the case that P holds.
 */

public class GlobalUniversality extends MonitoringLoop {
    
    protected Checkable p;

    
    public  GlobalUniversality(Checkable p) {
        this.p = p;

        this.setStatement(this.toString());
    }

    
    @Override
    public boolean invariant() {
        return (p.check() == CheckStatus.PASS);
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
            "Globally, it is always the case that P holds (AG(P), " + patternURL.toString() + "), where P is:\n\n\t\t" +
                    p.toString().replaceAll("\n", "\n\t\t");
    }

    
    public String TCTL() {
        String pStr;
        if (p instanceof MonitoringLoop) {
            pStr = ((MonitoringLoop) p).TCTL();
        } else {
            pStr = p.getClass().getSimpleName();
        }
        return "AG (" + pStr + ")";
    }

}
