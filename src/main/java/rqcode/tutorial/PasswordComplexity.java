package rqcode.tutorial;
import rqcode.concepts.Requirement;


public class PasswordComplexity extends Requirement {

    private String password;

    public PasswordComplexity(String password) {
        super("Requirement 2: Complexity Requirements");
        this.password = password;
    }

    // Method to check if the password has at least one uppercase letter
    private boolean hasUppercase() {
        return password.chars().anyMatch(Character::isUpperCase);
    }

    // Method to check if the password has at least one lowercase letter
    private boolean hasLowercase() {
        return password.chars().anyMatch(Character::isLowerCase);
    }

    // Method to check if the password has at least one digit
    private boolean hasDigit() {
        return password.chars().anyMatch(Character::isDigit);
    }

    // Method to check if the password has at least one special character
    private boolean hasSpecialCharacter() {
        return password.chars().anyMatch(ch -> "!@#$%^&*".indexOf(ch) >= 0);
    }

    @Override
    public CheckStatus check() {
        if (password == null) {
            return CheckStatus.INCOMPLETE; // Return INCOMPLETE if the password is null
        }

        boolean uppercaseCheck = hasUppercase();
        boolean lowercaseCheck = hasLowercase();
        boolean digitCheck = hasDigit();
        boolean specialCharacterCheck = hasSpecialCharacter();

        // Print the results of each check
        System.out.println("2.1.1: One uppercase letter (A-Z) - " + (uppercaseCheck ? "PASS" : "FAIL"));
        System.out.println("2.1.2: One lowercase letter (a-z) - " + (lowercaseCheck ? "PASS" : "FAIL"));
        System.out.println("2.1.3: One digit (0-9) - " + (digitCheck ? "PASS" : "FAIL"));
        System.out.println("2.1.4: One special character (!@#$%^&*) - " + (specialCharacterCheck ? "PASS" : "FAIL"));

        if (uppercaseCheck && lowercaseCheck && digitCheck && specialCharacterCheck) {
            return CheckStatus.PASS; // Return PASS if all complexity checks are passed
        } else {
            return CheckStatus.FAIL; // Return FAIL if any complexity check fails
        }
    }
}









