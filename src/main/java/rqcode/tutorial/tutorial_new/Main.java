package rqcode.tutorial.tutorial_new;

import rqcode.concepts.Checkable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize PasswordLockoutRequirement
        String username = "user1";
        PasswordLockoutRequirement lockoutRequirement = new PasswordLockoutRequirement(username);

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Simulate failed login attempt");
            System.out.println("2. Reset failed attempts");
            System.out.println("3. Check lockout status");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    lockoutRequirement.recordFailedAttempt();
                    System.out.println("Failed attempt recorded.");
                    break;

                case 2:
                    lockoutRequirement.resetFailedAttempts();
                    System.out.println("Failed attempts reset.");
                    break;

                case 3:
                    Checkable.CheckStatus status = lockoutRequirement.check();
                    System.out.println("Password lockout requirement check: " + status);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}