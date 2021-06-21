package stig;

public interface Enforceable {
    static enum EnforcementStatus {
        SUCCESS, FAILURE, INCOMPLETE
    };

    EnforcementStatus enforce();
}
