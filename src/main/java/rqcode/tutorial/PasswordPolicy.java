package rqcode.tutorial;

import rqcode.concepts.Requirement;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Password policy that checks if passwords meet specific complexity requirements.
 * Passwords n=must not be empty and must be at least 12 characters long and include at least:
 * 1. One uppercase letter - If this switch is enabled, the password must contain at least one uppercase letter.
 * 2. One lowercase letter - If this switch is enabled, the password must contain at least one lowercase letter.
 * 3. One digit - If this switch is enabled, the password must contain at least one digit. Digits are 1 2 3 4 5 6 7 8 9 0.
 * 4. One special character: !@#$%^&*
 */
public class PasswordPolicy extends Requirement {

    private String password;

    public PasswordPolicy(String password) {
        super("Passwords must be at least 12 characters long and include at least: one uppercase letter, one lowercase letter, one digit, and one special character.");
        this.password = password;
    }

    @Override
    public CheckStatus check() {
        if (password == null || password.isEmpty()) return CheckStatus.INCOMPLETE;

        if (!isLengthValid()) return CheckStatus.FAIL;
        if (!hasUppercase()) return CheckStatus.FAIL;
        if (!hasLowercase()) return CheckStatus.FAIL;
        if (!hasDigit()) return CheckStatus.FAIL;
        if (!hasSpecialCharacter()) return CheckStatus.FAIL;

        return CheckStatus.PASS;
    }

    private boolean isLengthValid() {
        return password.length() >= 12;
    }

    private boolean hasUppercase() {
        return Pattern.compile("[A-Z]").matcher(password).find();
    }

    private boolean hasLowercase() {
        return Pattern.compile("[a-z]").matcher(password).find();
    }

    private boolean hasDigit() {
        return Pattern.compile("[0-9]").matcher(password).find();
    }

    private boolean hasSpecialCharacter() {
        return Pattern.compile("[!@#$%^&*]").matcher(password).find();
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the terminal
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter password to check: ");
        String password = scanner.nextLine();

        PasswordPolicy policy = new PasswordPolicy(password);
        CheckStatus result = policy.check();

        switch (result) {
            case PASS:
                System.out.println("Password '" + password + "' - Status: SUCCESS");
                break;
            case FAIL:
                System.out.println("Password '" + password + "' - Status: FAIL");
                break;
            case INCOMPLETE:
                System.out.println("Password '" + password + "' - Status: INCOMPLETE");
                break;
        }

        // Close the scanner
        scanner.close();
    }
}
