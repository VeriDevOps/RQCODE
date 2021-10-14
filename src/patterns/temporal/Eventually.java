package patterns.temporal;

import stig.Checkable;

public class Eventually implements MonitoringLoop {

    Checkable p;

    public Eventually(Checkable p) {
        this.p = p;
    }

    @Override
    public boolean exitCondition() {
        return (p.check() == CheckStatus.PASS);
    }

    @Override
    public boolean postcondition() {
        return (p.check() == CheckStatus.PASS);
    }

    @Override
    public String TCTL() {
        return "AF (P)";
    }
}
