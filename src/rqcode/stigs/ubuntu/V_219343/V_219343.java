package rqcode.stigs.ubuntu.V_219343;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.UbuntuPackagePattern;

public class V_219343 implements Checkable {
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("aide", true);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}