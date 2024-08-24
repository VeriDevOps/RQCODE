package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;
import rqcode.concepts.CombinedRequirements;
import java.util.Arrays;
import java.util.List;

import rqcode.concepts.Requirement;
import java.util.Arrays;
import java.util.List;

public class MyCombinedReq extends CombinedRequirements {

    private final List<Requirement> requirements;

    // Constructor that accepts a list of requirements
    public MyCombinedReq(Requirement... requirements) {
        this.requirements = Arrays.asList(requirements);
    }

    @Override
    protected List<Requirement> getRequirements() {
        return requirements;
    }
}


