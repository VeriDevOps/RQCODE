package rqcode.stigs.ubuntu.V_219161;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.Package;

public class V_219161 implements Checkable {
    private Package _package = new Package("ufw", true);

    public CheckStatus check() {
        return _package.check();
    }

    public String toString() {
        return _package.toString();
    }
}