package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;

import java.util.regex.Pattern;

import java.util.regex.Pattern;

public class PasswordComplexity extends Requirement {
    private String password;

    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[!@#$%^&*]");

    public PasswordComplexity(String password) {
        super("Passwords must include at least one uppercase letter (A-Z), one lowercase letter (a-z), one digit (0-9), and one special character (e.g., !@#$%^&*).");
        this.password = password;
    }

    private boolean hasUppercase() {
        return UPPERCASE_PATTERN.matcher(password).find();
    }

    private boolean hasLowercase() {
        return LOWERCASE_PATTERN.matcher(password).find();
    }

    private boolean hasDigit() {
        return DIGIT_PATTERN.matcher(password).find();
    }

    private boolean hasSpecialCharacter() {
        return SPECIAL_CHAR_PATTERN.matcher(password).find();
    }

    @Override
    public CheckStatus check() {
        if (password == null || password.isEmpty()) {
            return CheckStatus.INCOMPLETE;
        }

        return (hasUppercase() && hasLowercase() && hasDigit() && hasSpecialCharacter()) ? CheckStatus.PASS : CheckStatus.FAIL;
    }
}




