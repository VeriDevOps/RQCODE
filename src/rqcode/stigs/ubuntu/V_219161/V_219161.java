package rqcode.stigs.ubuntu.V_219161;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.UbuntuPackagePattern;

public class V_219161 implements Checkable {
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("ufw", true);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}