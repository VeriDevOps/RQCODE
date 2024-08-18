package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;

import java.util.regex.Pattern;

import rqcode.concepts.Checkable;

public class PasswordComplexity extends Requirement {
    private String password;

    public PasswordComplexity(String password) {
        this.password = password;
    }

    @Override
    public Checkable.CheckStatus check() {
        if (!containsUppercaseLetter()) {
            return Checkable.CheckStatus.FAIL;
        }
        if (!containsLowercaseLetter()) {
            return Checkable.CheckStatus.FAIL;
        }
        if (!containsDigit()) {
            return Checkable.CheckStatus.FAIL;
        }
        if (!containsSpecialCharacter()) {
            return Checkable.CheckStatus.FAIL;
        }

        return Checkable.CheckStatus.PASS;
    }

    // Method to check if the password contains at least one uppercase letter (A-Z)
    private boolean containsUppercaseLetter() {
        return password.matches(".*[A-Z].*");
    }

    // Method to check if the password contains at least one lowercase letter (a-z)
    private boolean containsLowercaseLetter() {
        return password.matches(".*[a-z].*");
    }

    // Method to check if the password contains at least one digit (0-9)
    private boolean containsDigit() {
        return password.matches(".*\\d.*");
    }

    // Method to check if the password contains at least one special character (!@#$%^&*)
    private boolean containsSpecialCharacter() {
        return password.matches(".*[@#$%^&+=!].*");
    }
}





