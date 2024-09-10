package rqcode.tutorial.tutorial_new;
import rqcode.concepts.CombinedRequirements;
import rqcode.concepts.Requirement;
import java.util.Arrays;
import java.util.List;


public class PasswordPolicy extends CombinedRequirements {

    private final List<Requirement> requirements;

    // Constructor that accepts a list of requirements
    public PasswordPolicy(Requirement... requirements) {
        this.requirements = Arrays.asList(requirements);
    }

    @Override
    protected List<Requirement> getRequirements() {
        return requirements;
    }
}


