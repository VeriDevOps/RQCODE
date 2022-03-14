package rqcode.stigs.ubuntu.V_219319;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.Package;

public class V_219319 implements Checkable {
    private Package _package = new Package("opensc-pkcs11", true);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}