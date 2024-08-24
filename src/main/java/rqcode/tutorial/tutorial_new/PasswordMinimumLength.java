package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;

public class PasswordMinimumLength extends Requirement {
    private static final int MIN_LENGTH = 12;
    private String password;

    public PasswordMinimumLength(String password) {
        super("Requirement 1: Minimum Length");
        this.password = password;
    }

    // Check if the password is empty
    private boolean isEmpty() {
        return password == null || password.isEmpty();
    }

    // Check if the password meets the minimum length requirement
    private boolean isLengthValid() {
        return password != null && password.length() >= MIN_LENGTH;
    }

    @Override
    public CheckStatus check() {
        if (password == null) {
            return CheckStatus.INCOMPLETE; // Return INCOMPLETE if the password is null
        }

        boolean emptyCheck = isEmpty();
        boolean lengthCheck = isLengthValid();

        // Print the results of each check
        System.out.println("1.1: Passwords must be at least " + MIN_LENGTH + " characters long - " + (lengthCheck ? "PASS" : "FAIL"));
        System.out.println("1.2: Passwords should not be empty - " + (!emptyCheck ? "PASS" : "FAIL"));

        if (emptyCheck) {
            return CheckStatus.FAIL; // Return FAIL if the password is empty
        }

        if (lengthCheck) {
            return CheckStatus.PASS; // Return PASS if the password meets the length requirement
        } else {
            return CheckStatus.FAIL; // Return FAIL if the password does not meet the length requirement
        }
    }
}












