package rqcode.stigs.ubuntu.V_219304;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.Package;

public class V_219304 implements Checkable {
    private Package _package = new Package("vlock", true);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}