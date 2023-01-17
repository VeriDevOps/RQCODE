package rqcode.example;

import rqcode.concepts.Requirement;

/**
 * This class is an example of an RQCODE requirement.
 * (REQ2) Clock seconds must be between 0 and 59.
 * 
 * Adapted from
 * https://www.sciencedirect.com/science/article/abs/pii/S1477842416301981
 */
public class TickBoundaryRequirement extends Requirement {

    public TickBoundaryRequirement() {
        super("Clock seconds must be between 0 and 59.");
    }

    @Override
    public CheckStatus check() {
        if (Clock.seconds > 59) return CheckStatus.FAIL;
        if (Clock.seconds < 0) return CheckStatus.FAIL;            
        return CheckStatus.PASS;
    }
}
