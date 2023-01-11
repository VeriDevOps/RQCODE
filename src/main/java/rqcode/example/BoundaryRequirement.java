package rqcode.example;

import rqcode.concepts.Requirement;

/**
 * This class is an example of an RQCODE requirement.
 * (REQ2) Clock seconds are between 0 and 59.
 * 
 * Adapted from
 * https://www.sciencedirect.com/science/article/abs/pii/S1477842416301981
 */
public class BoundaryRequirement extends Requirement {

    public BoundaryRequirement() {
        super("Clock seconds are between 0 and 59.");
    }

    @Override
    public CheckStatus check() {
        if (Clock.seconds > 59) return CheckStatus.FAIL;
        if (Clock.seconds < 0) return CheckStatus.FAIL;            
        return CheckStatus.PASS;
    }
}
