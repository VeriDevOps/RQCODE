package rqcode.example;

import rqcode.concepts.Requirement;

/**
 * This class is an example of an RQCODE requirement.
 * (REQ1) A clock tick increments current second if it is smaller than 59.
 * 
 * Adapted from
 * https://www.sciencedirect.com/science/article/abs/pii/S1477842416301981
 */
public class BetterTickRequirement extends Requirement {

    public BetterTickRequirement() {
        super("A clock tick increments current second if it is smaller than 59");
    }

    @Override
    public CheckStatus check() {
        if (Clock.seconds > 59) return CheckStatus.FAIL;
        if (Clock.seconds < 0) return CheckStatus.FAIL;
        if (Clock.seconds == 59) {
            Clock.tick();
            if (Clock.seconds > 59) return CheckStatus.FAIL;                
        }
        if ((Clock.seconds + 1) != Clock.tick()) return CheckStatus.FAIL;
            
        return CheckStatus.PASS;
    }
}
