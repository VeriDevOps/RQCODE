package main.java.rqcode.patterns.temporal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import main.java.rqcode.concepts.Checkable;

/**
 * This is the monitoring service that periodically checks the temporal properties.
 */
@objid ("cff0e650-d9e0-4795-bd4e-36bd2484c305")
public abstract class MonitoringLoop implements Checkable {
    @objid ("0184ed02-53ba-47c7-ba87-756866a5bcb1")
    protected int boundary;

    @objid ("befe7bfa-d2bb-428e-8f36-ae277a6ea119")
    private final int variant(int i) {
        if (boundary > 0) {
            return i - 1;
        }
        return i;
    }

    @objid ("648e3bfb-db16-49cd-b53e-5a048e9a6675")
    protected int sleepMilliseconds() {
        return 1000;
    }

    @objid ("1b576f3b-c752-43d0-a449-e39d2887fec5")
    protected boolean invariant() {
        return true;
    }

    @objid ("241f314f-9555-4a88-aeca-81990e391b3e")
    protected boolean precondition() {
        return true;
    }

    @objid ("c0f55fd0-35f5-499f-967e-6a22e9055260")
    protected boolean postcondition() {
        return true;
    }

    @objid ("aaa5d195-1759-441e-9a4d-372d1bf84ab6")
    protected boolean exitCondition() {
        return false;
    }

    @objid ("1df654c2-80c7-437e-ae12-95f0169805d3")
    public main.java.rqcode.concepts.Checkable.CheckStatus check() {
        while(!precondition()) {
            try {
                Thread.sleep (sleepMilliseconds());
            } catch (InterruptedException e) {
                return Checkable.CheckStatus.INCOMPLETE;
            }
        }
        for (int i = boundary; i > 0 && !exitCondition(); i = variant(i)) {
            if (!invariant()) {
                return Checkable.CheckStatus.FAIL;
            }
            try {
                Thread.sleep (sleepMilliseconds());
            } catch (InterruptedException e) {
                return Checkable.CheckStatus.INCOMPLETE;
            }
        }
        if(!postcondition()) {
            return Checkable.CheckStatus.FAIL;
        }
        return Checkable.CheckStatus.PASS;
    }

    @objid ("c52bf698-72dc-40cf-924d-d1177c412f09")
    public abstract String TCTL();

}
