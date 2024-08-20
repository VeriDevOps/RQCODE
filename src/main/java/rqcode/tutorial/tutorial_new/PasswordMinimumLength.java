package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;
import rqcode.concepts.Checkable;

public class PasswordMinimumLength extends Requirement {
    private static final int MIN_LENGTH = 12;
    private String password;

    public PasswordMinimumLength(String password) {
        this.password = password;
    }

    private boolean isEmpty() {
        return password == null || password.isEmpty();
    }

    private boolean isLengthValid() {
        return password.length() >= MIN_LENGTH;
    }

    @Override
    public Checkable.CheckStatus check() {
        if (isEmpty()) {
            return Checkable.CheckStatus.INCOMPLETE;
        }
        return isLengthValid() ? Checkable.CheckStatus.PASS : Checkable.CheckStatus.FAIL;
    }

    @Override
    public String toString() {
        return "1.1: Passwords must be at least " + MIN_LENGTH + " characters long - " +
                (isLengthValid() ? "PASS" : "FAIL") + "\n" +
                "1.2: Passwords should not be empty - " + (isEmpty() ? "FAIL" : "PASS");
    }
}







