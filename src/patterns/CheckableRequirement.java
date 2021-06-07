package patterns;

public interface CheckableRequirement {
    static enum CheckStatus {
        PASS, FAIL, INCOMPLETE
    };

    CheckStatus check();
}