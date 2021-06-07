package patterns;

public interface EnforcableRequirement {
    static enum EnforcementStatus {
        SUCCESS, FAILURE, INCOMPLETE
    };

    EnforcementStatus enforce();
}