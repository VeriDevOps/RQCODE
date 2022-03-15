package rqcode.stigs.ubuntu.V_219304;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.UbuntuPackagePattern;

public class V_219304 implements Checkable {
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("vlock", true);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}