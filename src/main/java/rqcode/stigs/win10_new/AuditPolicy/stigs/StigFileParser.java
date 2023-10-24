package rqcode.stigs.win10_new.AuditPolicy.stigs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StigFileParser {
    public static void main(String[] args) {
        String fileName = "stig_input.txt"; // Change this to your file's path if needed
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { // Added closing parenthesis
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s"); // Split by spaces
                if (parts.length == 3) {
                    String stig = parts[0];
                    String parameter = parts[1];
                    String guid = parts[2];
                    System.out.println("STIG: " + stig);
                    System.out.println("Parameter: " + parameter);
                    System.out.println("GUID: " + guid);
                    System.out.println(); // Separate records
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
