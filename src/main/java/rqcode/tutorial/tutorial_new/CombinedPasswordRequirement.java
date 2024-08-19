package rqcode.tutorial.tutorial_new;

import rqcode.concepts.Requirement;
import rqcode.concepts.Checkable;
import java.util.ArrayList;
import java.util.List;


public class CombinedPasswordRequirement extends Requirement {
    private PasswordMinimumLength minLengthRequirement;
    private PasswordComplexity complexityRequirement;
    private List<Checkable> requirements = new ArrayList<>();

    public CombinedPasswordRequirement(String password) {
        this.minLengthRequirement = new PasswordMinimumLength(password);
        this.complexityRequirement = new PasswordComplexity(password);

        requirements.add(minLengthRequirement);
        requirements.add(complexityRequirement);
    }

    @Override
    public Checkable.CheckStatus check() {
        return aggregateChecks(requirements);
    }

    private Checkable.CheckStatus aggregateChecks(List<Checkable> checks) {
        boolean allPass = true;

        for (Checkable checkable : checks) {
            Checkable.CheckStatus status = checkable.check();
            if (status != Checkable.CheckStatus.PASS) {
                allPass = false;
            }
        }

        return allPass ? Checkable.CheckStatus.PASS : Checkable.CheckStatus.FAIL;
    }

    @Override
    public String toString() {
        return minLengthRequirement.toString() + "\n" + complexityRequirement.toString();
    }
}

