package stig;

public interface Checkable {
    static enum CheckStatus {
        PASS, FAIL, INCOMPLETE
    };

    CheckStatus check();
}
