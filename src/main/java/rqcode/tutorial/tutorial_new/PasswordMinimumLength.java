package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;


public class PasswordMinimumLength extends Requirement {
    private static final int MIN_LENGTH = 12;
    private String password;

    public PasswordMinimumLength(String password) {
        super("Passwords must be at least 12 characters long and should not be empty.");
        this.password = password;
    }

    private boolean isEmpty() {
        return password == null || password.isEmpty();
    }

    private boolean isLengthValid() {
        return password.length() >= MIN_LENGTH;
    }

    @Override
    public CheckStatus check() {
        if (isEmpty()) {
            return CheckStatus.INCOMPLETE;
        }
        return isLengthValid() ? CheckStatus.PASS : CheckStatus.FAIL;
    }
}




