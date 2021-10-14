package patterns.temporal;

import stig.Checkable;

public class GlobalResponseUntil implements MonitoringLoop {
    Checkable p, q, r;

    public GlobalResponseUntil(Checkable p, Checkable q, Checkable r) {
        this.p = p;
        this.q = q;
        this.r = r;
    }

    @Override
    public boolean precondition() {
        return (r.check() == CheckStatus.FAIL) && (p.check() == CheckStatus.PASS);
    }

    @Override
    public boolean exitCondition() {
        return (r.check() == CheckStatus.PASS) || (q.check() == CheckStatus.PASS);
    }

    @Override
    public boolean postcondition() {
        if (q.check() == CheckStatus.FAIL) {
            Eventually eventuallyQ = new Eventually(q);
            return (eventuallyQ.check() == CheckStatus.PASS);
        }
        return true;
    }

    @Override
    public String TCTL() {
        return "AG (P ==> ((AF (Q)) U R))";
    }
}
