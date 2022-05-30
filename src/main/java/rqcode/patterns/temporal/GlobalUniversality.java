package main.java.rqcode.patterns.temporal;

import java.net.MalformedURLException;
import java.net.URL;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import main.java.rqcode.concepts.Checkable;

/**
 * Temporal requirements pattern:
 * Globally, Universally: Globally, it is always the case that P holds.
 */
@objid ("261fe93b-c43b-41fe-9791-14aa09eb59f3")
public class GlobalUniversality extends MonitoringLoop {
    @objid ("a7d1a4ee-c2df-46dd-98c5-5760ba9a1435")
    protected Checkable p;

    @objid ("8b6866b3-60ec-4e35-9ec2-81df506da7fa")
    public  GlobalUniversality(Checkable p) {
        this.p = p;
    }

    @objid ("b3b6e41a-2443-46bb-8d7e-f8f180c641fa")
    @Override
    public boolean invariant() {
        return (p.check() == CheckStatus.PASS);
    }

    @objid ("8a1e8162-bd0b-41e4-98cc-51fafa113db9")
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

    @objid ("b6c21e6f-8942-4c48-9fca-9f1615e3845d")
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
