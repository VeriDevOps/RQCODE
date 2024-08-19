package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;

import rqcode.concepts.Checkable;

public class PasswordComplexity extends Requirement {
    private String password;

    public PasswordComplexity(String password) {
        this.password = password;
    }

    @Override
    public Checkable.CheckStatus check() {
        boolean allPass = true;

        if (!containsUppercaseLetter()) {
            System.out.println("Requirement 2.1.1: One uppercase letter (A-Z) - FAIL");
            allPass = false;
        } else {
            System.out.println("Requirement 2.1.1: One uppercase letter (A-Z) - PASS");
        }

        if (!containsLowercaseLetter()) {
            System.out.println("Requirement 2.1.2: One lowercase letter (a-z) - FAIL");
            allPass = false;
        } else {
            System.out.println("Requirement 2.1.2: One lowercase letter (a-z) - PASS");
        }

        if (!containsDigit()) {
            System.out.println("Requirement 2.1.3: One digit (0-9) - FAIL");
            allPass = false;
        } else {
            System.out.println("Requirement 2.1.3: One digit (0-9) - PASS");
        }

        if (!containsSpecialCharacter()) {
            System.out.println("Requirement 2.1.4: One special character (!@#$%^&*) - FAIL");
            allPass = false;
        } else {
            System.out.println("Requirement 2.1.4: One special character (!@#$%^&*) - PASS");
        }

        return allPass ? Checkable.CheckStatus.PASS : Checkable.CheckStatus.FAIL;
    }

    private boolean containsUppercaseLetter() {
        return password.matches(".*[A-Z].*");
    }

    private boolean containsLowercaseLetter() {
        return password.matches(".*[a-z].*");
    }

    private boolean containsDigit() {
        return password.matches(".*\\d.*");
    }

    private boolean containsSpecialCharacter() {
        return password.matches(".*[@#$%^&+=!].*");
    }

    @Override
    public String toString() {
        return "Requirement 2: Complexity Requirements";
    }
}






