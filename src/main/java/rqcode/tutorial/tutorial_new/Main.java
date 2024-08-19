package rqcode.tutorial.tutorial_new;
import java.util.Scanner;
import rqcode.concepts.Checkable;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        CombinedPasswordRequirement combinedRequirement = new CombinedPasswordRequirement(password);
        System.out.println(combinedRequirement.toString());

        Checkable.CheckStatus finalStatus = combinedRequirement.check();
        System.out.println("Final Aggregate Status: " + finalStatus.name());

        scanner.close();
    }
}

