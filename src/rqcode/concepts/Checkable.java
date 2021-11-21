package rqcode.concepts;

/**
 * Implementations of this interface are requirements that can be checked programmatically through the check function.
 */
public interface Checkable {
    enum CheckStatus {
        PASS, FAIL, INCOMPLETE
    }

    /**
     * Checks whether the current environment satisfies the requirement of not.
     * @return The result of the check or whether the check was unable to be complete.
     */
    CheckStatus check();
}
