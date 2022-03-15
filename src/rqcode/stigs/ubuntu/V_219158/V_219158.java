package rqcode.stigs.ubuntu.V_219158;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.UbuntuPackagePattern;

public class V_219158 implements Checkable {
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("rsh-server", false);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}