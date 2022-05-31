package rqcode.patterns.temporal;

import java.net.MalformedURLException;
import java.net.URL;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.concepts.Checkable;

/**
 * Temporal requirements pattern:
 * Globally, Real-time Response: Globally, it is always the case that if P holds, the S eventually holds within T time units.
 */
@objid ("fb235eed-871d-4c70-bc60-b341f4c48552")
public class GlobalResponseTimed extends MonitoringLoop {
    @objid ("7afec25e-64c7-4e9f-a1b9-f8bba2924fa8")
    private Checkable s;

    @objid ("7dc76df8-18ec-4312-9a10-fcfcf68be561")
    private Checkable r;

    @objid ("6f765b66-c774-45d8-b2e9-2c1ec3a8b1f2")
    public  GlobalResponseTimed(Checkable s, Checkable r, int boundary) {
        this.s = s;
        this.r = r;
        this.boundary = boundary;
    }

    @objid ("9fe3738a-b1b7-4edf-9a42-dcaeae89a2e7")
    @Override
    public boolean precondition() {
        return (s.check() == CheckStatus.PASS);
    }

    @objid ("e3da4ac8-e956-4b19-aa44-e90370d7c810")
    @Override
    public boolean postcondition() {
        return (r.check() == CheckStatus.PASS);
    }

    @objid ("ba3da87e-ab62-4029-bf53-6831b278f3d8")
    @Override
    public boolean exitCondition() {
        return (r.check() == CheckStatus.PASS);
    }

    @objid ("339a1c0a-9bdb-48d2-8904-8c2d2a884d8b")
    @Override
    public String toString() {
        URL patternURL;
        try {
            patternURL = new URL("https://people.cs.ksu.edu/~dwyer/SPAT/ctl.html#Response");
        } catch (MalformedURLException e) {
            return "";
        }
        return
                "Globally, it is always the case that if S holds, the R will eventually hold within " + boundary +
                " seconds (" + patternURL.toString() + "), where S is:\n\n\t\t" +
                        s.toString().replaceAll("\n", "\n\t\t") +
                "\nand R is:\n\n\t\t:" +
                        r.toString().replaceAll("\n", "\n\t\t");
    }

    @objid ("cd34643b-bae2-4ed4-9821-11dfd49542df")
    @Override
    public String TCTL() {
        String sStr, rStr;
        if (s instanceof MonitoringLoop) {
            sStr = ((MonitoringLoop) s).TCTL();
        } else {
            sStr = s.getClass().getSimpleName();
        }
        if (r instanceof MonitoringLoop) {
            rStr = ((MonitoringLoop) r).TCTL();
        } else {
            rStr = r.getClass().getSimpleName();
        }
        return "AG((" + sStr + ") ==> (AF <= " + boundary + " (" + rStr + ")))";
    }

}
