package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Checkable;
import rqcode.concepts.Requirement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to capture user input
        /* Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter a password
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Create instances of requirements with the user-provided password
        Requirement R1 = new PasswordMinimumLength(password);
        Requirement R2 = new PasswordComplexity(password);

        // Create an instance of PasswordPolicy that combines the requirements
        PasswordPolicy myReq = new PasswordPolicy(R1, R2);

        // Perform the check and print the detailed result
        System.out.println("Requirement 1: Minimum Length");
        R1.check();
        System.out.println("Requirement 2: Complexity Requirements");
        R2.check();

        // Determine the final status
        Checkable.CheckStatus status = myReq.check();
        System.out.println("Final Status: " + status);

        // Close the scanner to prevent resource leaks
        scanner.close();
   */

        System.out.print("Enter the date of the last password update (yyyy-MM-dd HH:mm): ");
        String inputDate = scanner.nextLine();

        System.out.println("User input captured: " + inputDate); // Debug message

        // Parse the input date into LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime lastUpdated = LocalDateTime.parse(inputDate, formatter);

        // Create a mock PasswordStorage object and store the last update timestamp
        PasswordStorage passwordStorage = new PasswordStorage();
        String username = "user1"; // Mock username
        passwordStorage.storePassword(username, lastUpdated);

        System.out.println("Password last updated: " + passwordStorage.getPasswordTimestamp(username));

        // Create a PasswordUpdateRequirement instance
        PasswordUpdateRequirement requirement = new PasswordUpdateRequirement(passwordStorage, username);

        // Check the requirement
        Checkable.CheckStatus status = requirement.check();
        System.out.println("Password update requirement check: " + status);

        // Simulate an expired password scenario for testing
        passwordStorage.storePassword(username, lastUpdated.minusDays(100));
        System.out.println("Password update requirement check after expiry: " + requirement.check());

        System.out.println("Program finished successfully!"); // Debug message
        scanner.close();
    }
}