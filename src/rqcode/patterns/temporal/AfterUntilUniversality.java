package rqcode.patterns.temporal;

import java.net.MalformedURLException;
import java.net.URL;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import rqcode.concepts.Checkable;

/**
 * Temporal requirements pattern:
 * After Q Until R Universally P: After Q, it is always the case that P holds until R holds.
 */
@objid ("d980ee23-7e0b-46b6-906d-6eac33ab6af2")
public class AfterUntilUniversality extends MonitoringLoop {
    @objid ("5715d8cf-bd87-42b6-a2e8-a7a43cb398a6")
    private Checkable q;

    @objid ("c82ab364-af88-40b0-8689-773438ce88a5")
    private Checkable p;

    @objid ("df4b10b6-78df-49a3-86e8-88a6e26d5630")
    private Checkable r;

    @objid ("0b5a0852-aa61-4f85-a9eb-d7c9d3cf8a50")
    public  AfterUntilUniversality(Checkable q, Checkable p, Checkable r) {
        this.q = q;
        this.p = p;
        this.r = r;
    }

    @objid ("64d73a60-74d4-4205-9300-3bab6f273ae5")
    @Override
    public boolean precondition() {
        return (q.check() == CheckStatus.PASS);
    }

    @objid ("70416870-8de1-447d-85c8-736fabd38a54")
    @Override
    public boolean invariant() {
        return (p.check() == CheckStatus.PASS || exitCondition());
    }

    @objid ("9dee66bb-23b0-4d93-8f1b-bdc258c9f0e6")
    @Override
    public boolean exitCondition() {
        return (r.check() == CheckStatus.PASS);
    }

    @objid ("0c91e464-d58b-4b2e-8202-39636ccdc1d7")
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

    @objid ("422d9d5a-75a8-4a0f-9a0e-6b06fbe4dc37")
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
