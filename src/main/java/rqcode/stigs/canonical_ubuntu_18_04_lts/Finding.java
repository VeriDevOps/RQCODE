package main.java.rqcode.stigs.canonical_ubuntu_18_04_lts;

import main.java.rqcode.concepts.Checkable;

public abstract class Finding implements Checkable {
    protected Checkable _checkable;

    public CheckStatus check() {
        return _checkable.check();
    }

    public String toString() {
        return _checkable.toString();
    }
}
