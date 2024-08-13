package rqcode.tutorial.tutorial_new;

import rqcode.concepts.Checkable.CheckStatus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        CombinedPasswordRequirement passwordRequirement = new CombinedPasswordRequirement(password);
        CheckStatus status = passwordRequirement.check();

        switch (status) {
            case PASS:
                System.out.println("Password is correct");
                break;
            case INCOMPLETE:
                System.out.println("Password is empty or verification cannot be executed.");
                break;
            case FAIL:
                System.out.println("Password is incorrect");
                break;
        }

        scanner.close();
    }
}
