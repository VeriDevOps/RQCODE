package rqcode.concepts;
import java.util.List;

public abstract class CombinedRequirements extends Requirement {

    @Override
    public CheckStatus check() {
        // Get all attributes of type Requirement
        List<Requirement> requirements = getRequirements();

        // Iterate over all requirements and check them
        for (Requirement req : requirements) {
            CheckStatus status = req.check();
            if (status != CheckStatus.PASS) {
                return status;  // Return the first non-passing status
            }
        }
        return CheckStatus.PASS;  // If all requirements pass, return PASS
    }

    // Abstract method that must return a list of requirements
    protected abstract List<Requirement> getRequirements();
}



