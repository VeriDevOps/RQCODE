package rqcode.example;

/**
 * This class is an example of an RQCODE requirement. 
 * It represents the requirement that the clock seconds must be between 0 and 59.
 * 
 * Adapted from https://www.sciencedirect.com/science/article/abs/pii/S1477842416301981 
 */
public class SecondsRequirement extends Requirement {

    public SecondsRequirement() {
        super("The clock seconds must be between 0 and 59");
    }

    @Override
    public CheckStatus check() {
        if (Clock.seconds>59) return CheckStatus.FAIL;
        if (Clock.seconds<0) return CheckStatus.FAIL;
        return CheckStatus.PASS;
    }    
}
