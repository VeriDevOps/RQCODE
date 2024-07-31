package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;

public class CombinedPasswordRequirement extends Requirement {
    private String password;

    public CombinedPasswordRequirement(String password) {
        super("Passwords must meet minimum length and complexity requirements.");
        this.password = password;
    }

    @Override
    public CheckStatus check() {
        PasswordMinimumLength minimumLengthRequirement = new PasswordMinimumLength(password);
        PasswordComplexity complexityRequirement = new PasswordComplexity(password);

        CheckStatus lengthStatus = minimumLengthRequirement.check();
        if (lengthStatus == CheckStatus.INCOMPLETE) {
            return CheckStatus.INCOMPLETE;
        } else if (lengthStatus == CheckStatus.FAIL) {
            return CheckStatus.FAIL;
        }

        CheckStatus complexityStatus = complexityRequirement.check();
        return complexityStatus;
    }
}




