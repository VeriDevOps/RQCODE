package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;

import rqcode.concepts.Checkable;




import java.util.regex.Pattern;

public class PasswordComplexity extends Requirement {
    private String password;
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[@#$%^&+=!]");

    public PasswordComplexity(String password) {
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
    public Checkable.CheckStatus check() {
        boolean allPass = true;

        if (!hasUppercase()) {
            System.out.println("2.1.1: One uppercase letter (A-Z) - FAIL");
            allPass = false;
        } else {
            System.out.println("2.1.1: One uppercase letter (A-Z) - PASS");
        }

        if (!hasLowercase()) {
            System.out.println("2.1.2: One lowercase letter (a-z) - FAIL");
            allPass = false;
        } else {
            System.out.println("2.1.2: One lowercase letter (a-z) - PASS");
        }

        if (!hasDigit()) {
            System.out.println("2.1.3: One digit (0-9) - FAIL");
            allPass = false;
        } else {
            System.out.println("2.1.3: One digit (0-9) - PASS");
        }

        if (!hasSpecialCharacter()) {
            System.out.println("2.1.4: One special character (!@#$%^&*) - FAIL");
            allPass = false;
        } else {
            System.out.println("2.1.4: One special character (!@#$%^&*) - PASS");
        }

        return allPass ? Checkable.CheckStatus.PASS : Checkable.CheckStatus.FAIL;
    }

    @Override
    public String toString() {
        return "Requirement 2: Complexity Requirements\n" +
                "2.1.1: One uppercase letter (A-Z) - " + (hasUppercase() ? "PASS" : "FAIL") + "\n" +
                "2.1.2: One lowercase letter (a-z) - " + (hasLowercase() ? "PASS" : "FAIL") + "\n" +
                "2.1.3: One digit (0-9) - " + (hasDigit() ? "PASS" : "FAIL") + "\n" +
                "2.1.4: One special character (!@#$%^&*) - " + (hasSpecialCharacter() ? "PASS" : "FAIL");
    }
}







