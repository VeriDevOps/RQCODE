package rqcode.stigs.ubuntu.V_219318;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.Package;

public class V_219318 implements Checkable {
    private Package _package = new Package("libpam-pkcs11", true);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}