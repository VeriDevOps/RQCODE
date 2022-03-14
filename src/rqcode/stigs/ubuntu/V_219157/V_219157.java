package rqcode.stigs.ubuntu.V_219157;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.Package;

public class V_219157 implements Checkable {
    private Package _package = new Package("nis", false);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}
