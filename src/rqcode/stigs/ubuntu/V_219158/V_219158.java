package rqcode.stigs.ubuntu.V_219158;

import rqcode.concepts.Checkable;
import rqcode.stigs.ubuntu.Package;

public class V_219158 implements Checkable {
    private Package _package = new Package("rsh-server", false);

    public CheckStatus check() {
        return _package.check();
    }
}