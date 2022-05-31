package rqcode.patterns.temporal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.concepts.Checkable;

/**
 * Temporal requirements pattern:
 * P always eventually holds
 */
@objid ("13b3ffcb-44cf-478c-8a1c-8677643ad22a")
public class Eventually extends MonitoringLoop {
    @objid ("1882cfd3-59d4-498f-8b7f-885c574b3f5e")
    Checkable p;

    @objid ("38032ed2-fcc4-4b2a-8bd4-c92ceb8ca351")
    public  Eventually(Checkable p) {
        this.p = p;
    }

    @objid ("537865ed-7bc9-48d0-8e72-edc354d60729")
    @Override
    public boolean exitCondition() {
        return (p.check() == CheckStatus.PASS);
    }

    @objid ("97148c2f-caf9-4428-8d1b-e861824d628a")
    @Override
    public boolean postcondition() {
        return (p.check() == CheckStatus.PASS);
    }

    @objid ("0c47a96e-af6f-4eac-ad42-4a20c094ddc0")
    @Override
    public String toString() {
        return "P always eventually holds, where P is:\n\n\t\t" +
                p.toString().replaceAll("\n", "\n\t\t");
    }

    @objid ("654017b1-a671-4b24-b44b-76c638ca94d2")
    @Override
    public String TCTL() {
        String pStr;
        if (p instanceof MonitoringLoop) {
            pStr = ((MonitoringLoop) p).TCTL();
        } else {
            pStr = p.getClass().getSimpleName();
        }
        return "AF (" + pStr + ")";
    }

}
