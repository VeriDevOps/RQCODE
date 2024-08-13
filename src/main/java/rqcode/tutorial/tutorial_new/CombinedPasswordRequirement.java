package rqcode.tutorial.tutorial_new;

import rqcode.concepts.Checkable.CheckStatus;
import rqcode.concepts.Requirement;

import java.lang.reflect.Field;

public class CombinedPasswordRequirement extends Requirement {
    private final PasswordMinimumLength passwordMinimumLength;
    private final PasswordComplexity passwordComplexity;

    public CombinedPasswordRequirement(String password) {
        this.passwordMinimumLength = new PasswordMinimumLength(password);
        this.passwordComplexity = new PasswordComplexity(password);
    }

    @Override
    public CheckStatus check() {
        return aggregateChecks();
    }

    private CheckStatus aggregateChecks() {
        CheckStatus finalStatus = CheckStatus.PASS;

        // Use reflection to get all fields of type Requirement
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Requirement.class.isAssignableFrom(field.getType())) {
                try {
                    // Make the private fields accessible
                    field.setAccessible(true);
                    Requirement requirement = (Requirement) field.get(this);
                    CheckStatus status = requirement.check();

                    // Print debugging information
                    System.out.println("Checking: " + field.getName() + " - Status: " + status);

                    // Aggregate the status
                    if (status == CheckStatus.FAIL) {
                        finalStatus = CheckStatus.FAIL;
                    } else if (status == CheckStatus.INCOMPLETE && finalStatus != CheckStatus.FAIL) {
                        finalStatus = CheckStatus.INCOMPLETE;
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return CheckStatus.INCOMPLETE; // Return INCOMPLETE if reflection fails
                }
            }
        }

        return finalStatus;
    }
}
