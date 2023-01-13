package rqcode.temporal_patterns;

import java.net.MalformedURLException;
import java.net.URL;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.concepts.Checkable;

/**
 * Temporal requirements pattern:
 * Timed Globally, Universally: Globally, it is always the case that if P held for T time units, then S holds.
 */

public class GlobalUniversalityTimed extends GlobalUniversality {
    
    public  GlobalUniversalityTimed(Checkable p, int boundary) {
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
    public String TCTL() {
        String pStr;
        if (p instanceof MonitoringLoop) {
            pStr = ((MonitoringLoop) p).TCTL();
        } else {
            pStr = p.getClass().getSimpleName();
        }
        return "AG >=" + this.boundary + " (" + pStr + ")";
    }

}
