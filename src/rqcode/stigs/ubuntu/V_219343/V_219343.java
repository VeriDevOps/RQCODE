package rqcode.stigs.ubuntu.V_219343;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.Package;

public class V_219343 implements Checkable {
    private Package _package = new Package("aide", true);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}