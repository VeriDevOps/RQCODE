package rqcode.tutorial;

import rqcode.concepts.Checkable;
import rqcode.concepts.Requirement;

import java.util.Scanner;

/**
 * Main class for the RQCODE Password Policy Tutorial.
 *
 * This class demonstrates how to use RQCODE to verify password requirements
 * by combining multiple requirements into a single policy check.
 *
 * @see PasswordMinimumLength
 * @see PasswordComplexity
 * @see PasswordPolicy
 */
public class MainFull {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Create instances of requirements with the user-provided password
        Requirement R1 = new PasswordMinimumLength(password);
        Requirement R2 = new PasswordComplexity(password);

        // Create an instance of PasswordPolicy that combines the requirements
        PasswordPolicy passwordPolicy = new PasswordPolicy(R1, R2);

        // Perform the check and print the detailed result
        System.out.println("Requirement 1: Minimum Length");
        R1.check();

        System.out.println("Requirement 2: Complexity Requirements");
        R2.check();

        // Determine the final status
        Checkable.CheckStatus status = passwordPolicy.check();
        System.out.println("Final Status: " + status);

        scanner.close();
    }
}
