package rqcode.example;

import rqcode.concepts.Requirement;

/**
 * This class is an example of an RQCODE requirement.
 * (REQ1) A clock tick increments current second if it is smaller than 59.
 * 
 * Adapted from
 * https://www.sciencedirect.com/science/article/abs/pii/S1477842416301981
 */
public class TickRequirement extends Requirement {

    public TickRequirement() {
        super("A clock tick increments current second if it is smaller than 59");
    }

    @Override
    public CheckStatus check() {
        if (Clock.seconds < 59)
            return ((Clock.seconds + 1) == Clock.tick()) ? 
            CheckStatus.PASS : CheckStatus.FAIL;
        
        return ((Clock.seconds + 1) != Clock.tick()) ? 
            CheckStatus.PASS : CheckStatus.FAIL;
    }
}
