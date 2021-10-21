package patterns.temporal;

import stig.Checkable;

public abstract class MonitoringLoop implements Checkable {

    final private int variant(int i) {
        if (boundary > 0) {
            return i - 1;
        }
        return i;
    }

    protected int boundary;

    protected int sleepMilliseconds() { return 1000; }

    protected boolean invariant() { return true; }

    protected boolean precondition() { return true; }

    protected boolean postcondition() { return true; }

    protected boolean exitCondition() { return false; }

    public Checkable.CheckStatus check() {
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

    abstract public String TCTL();
}
