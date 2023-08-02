package rqcode.stigs.canonical_ubuntu_18_04_lts;

import rqcode.concepts.Checkable;
import rqcode.concepts.Enforceable;

import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219147.V_219147;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219148.V_219148;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219149.V_219149;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219156.V_219156;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219160.V_219160;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219163.V_219163;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219164.V_219164;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219166.V_219166;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219157.V_219157;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219158.V_219158;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219161.V_219161;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219177.V_219177;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219304.V_219304;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219318.V_219318;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219319.V_219319;
import rqcode.stigs.canonical_ubuntu_18_04_lts.V_219343.V_219343;

/**
 * Example of instantiation of the RQCODE for UBUNTU STIGs.
 */

public class Main {

    public static void main(String[] args) throws Exception {

        // List of testing STIGs
        Object[] stigList={ new V_219157(), new V_219158(), new V_219161(), new V_219177(),
            new V_219304(), new V_219318(), new V_219319(), new V_219343(),
            new V_219147(), new V_219148(), new V_219149(), new V_219156(),
            new V_219160(), new V_219163(), new V_219164(), new V_219166()};

        // Run settings
        int minErrorGate = 0; // min amount of errors to fail
        boolean enforceFix = false; // attempt to fix failed tests

        try {
            if (System.getProperty("gate") != null)
        minErrorGate = Integer.parseInt(System.getProperty("gate"));
            if (System.getProperty("fix") != null)
        enforceFix = true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int testsPassed = 0; int testsFailed = 0;

        for (int i=0; i < stigList.length; i++) {
            // The object is not an appropriate testable requirement, SKIP test
            if (!Checkable.class.isAssignableFrom(stigList[i].getClass())) {
                System.out.println("SKIP object of " + stigList[i].getClass());
                continue;
            }

            // Test run
            System.out.println(stigList[i].toString());
            String result = ((Checkable)(stigList[i])).check().toString();
            System.out.println(result);

            // PASS, end the current test
            if (result == "PASS") {
                testsPassed++;
                continue;
            }

            // Auto fix is disabled, FAIL test
            if (!enforceFix) {
                testsFailed++;
                continue;
            }

            // The object has no fix implemented, FAIL test
            if (!Enforceable.class.isAssignableFrom(stigList[i].getClass()) ) {
                System.out.println("No fix for this issue");
                testsFailed++;
                continue;
            }

            // Run fixing
            result = ((Enforceable)(stigList[i])).enforce().toString();
            System.out.println("Fix status: " + result);
            if (result == "SUCCESS")
                testsPassed++;
                    else 
                testsFailed++;
        }

        // Short report print
        System.out.println("\n--- REPORT ---");
        System.out.println("Tests passed: " + testsPassed + "\n" + "Tests failed or incomplete: " + testsFailed);

        if (minErrorGate > 0 && testsFailed >= minErrorGate) {
            System.out.println();
            throw new Exception(String.format("\u001B[31mQuality gates are not passed: %s/%s\u001B[0m", testsFailed, minErrorGate));
        }
    }
}