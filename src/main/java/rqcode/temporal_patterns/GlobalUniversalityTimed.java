package rqcode.temporal_patterns;

import java.net.MalformedURLException;
import java.net.URL;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.concepts.Checkable;

/**
 * Temporal requirements pattern:
 * Timed Globally, Universally: Globally, it is always the case that if P held for T time units, then S holds.
 */
@objid ("de611e84-699d-48ef-b4d6-00a6aea54092")
public class GlobalUniversalityTimed extends GlobalUniversality {
    @objid ("c6770cc9-dca4-4341-a4d9-21d1dc238358")
    public  GlobalUniversalityTimed(Checkable p, int boundary) {
        super(p);
        this.boundary = boundary;
    }

    @objid ("11869626-2688-4b55-8a78-1969e7476b66")
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

    @objid ("1802deab-5077-4960-89a9-e2476e7d2794")
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
