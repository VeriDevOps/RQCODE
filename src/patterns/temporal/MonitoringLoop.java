package patterns.temporal;

import stig.Checkable;

public interface MonitoringLoop extends Checkable {

    String TCTL ();

    default int boundary() {
        return Integer.MAX_VALUE;
    }

    default int timeUnit() {
        return 1000;
    }

    default boolean invariant() {
        return true;
    }

    default boolean precondition() {
        return true;
    }

    default boolean postcondition() {
        return true;
    }

    default boolean exitCondition() {
        return false;
    }

    default boolean timed() { return false; }

    private int variant(int i) {
        if (timed()) {
            return i - 1;
        }
        return i;
    }

    default Checkable.CheckStatus check() {
        while(!precondition()) {
            try {
                Thread.sleep (timeUnit());
            } catch (InterruptedException e) {
                return Checkable.CheckStatus.INCOMPLETE;
            }
        }
        for (int i = boundary(); i > 0 && !exitCondition(); i = variant(i)) {
            if (!invariant()) {
                return Checkable.CheckStatus.FAIL;
            }
            try {
                Thread.sleep (timeUnit());
            } catch (InterruptedException e) {
                return Checkable.CheckStatus.INCOMPLETE;
            }
        }
        if(!postcondition()) {
            return Checkable.CheckStatus.FAIL;
        }
        return Checkable.CheckStatus.PASS;
    }

}
