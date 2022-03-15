package rqcode.stigs.ubuntu.V_219318;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.UbuntuPackagePattern;

public class V_219318 implements Checkable {
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("libpam-pkcs11", true);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}