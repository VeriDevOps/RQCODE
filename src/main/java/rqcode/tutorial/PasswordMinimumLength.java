package rqcode.tutorial;
import rqcode.concepts.Requirement;

public class PasswordMinimumLength extends Requirement {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 64;
    private String password;

    public PasswordMinimumLength(String password) {
        super("Requirement 1: Password Length Requirements");
        this.password = password;
    }

    // Check if the password is empty
    private boolean isEmpty() {
        return password == null || password.isEmpty();
    }

    // Check if the password meets the length requirements
    private boolean isLengthValid() {
        return password != null && password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH;
    }

    @Override
    public CheckStatus check() {
        if (password == null) {
            return CheckStatus.INCOMPLETE; // Return INCOMPLETE if the password is null
        }

        boolean emptyCheck = isEmpty();
        boolean lengthCheck = isLengthValid();

        // Print the results of each check
        System.out.println("1.1: Passwords must be at least " + MIN_LENGTH + " characters long - " + (password.length() >= MIN_LENGTH ? "PASS" : "FAIL"));
        System.out.println("1.2: Passwords must be no more than " + MAX_LENGTH + " characters long - " + (password.length() <= MAX_LENGTH ? "PASS" : "FAIL"));
        System.out.println("1.3: Passwords should not be empty - " + (!emptyCheck ? "PASS" : "FAIL"));

        if (emptyCheck) {
            return CheckStatus.FAIL; // Return FAIL if the password is empty
        }

        if (lengthCheck) {
            return CheckStatus.PASS; // Return PASS if the password meets the length requirements
        } else {
            return CheckStatus.FAIL; // Return FAIL if the password does not meet the length requirements
        }
    }
}













