package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Checkable;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        CombinedPasswordRequirement requirement = new CombinedPasswordRequirement(password);
        Checkable.CheckStatus status = requirement.check();
        System.out.println("Password check status: " + status);
    }
}

