package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Checkable;
import rqcode.concepts.Requirement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to capture user input
        Scanner scanner = new Scanner(System.in);

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
    }
}





