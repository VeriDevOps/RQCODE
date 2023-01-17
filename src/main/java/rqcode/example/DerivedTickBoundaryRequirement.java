package rqcode.example;

/**
 * This class is a reuse example an RQCODE requirement by an inheritance.
 * 
 */

public class DerivedTickBoundaryRequirement extends TickIncrementRequirement {
    public DerivedTickBoundaryRequirement() {
        super.setStatement(super.getStatement() +"\nIn addition, Clock seconds value must be between 0 and 59.");
    }

    @Override
    public CheckStatus check() {
        if (super.check()==CheckStatus.FAIL) return CheckStatus.FAIL;
        if (Clock.seconds > 59) return CheckStatus.FAIL;
        if (Clock.seconds < 0) return CheckStatus.FAIL;            
        return CheckStatus.PASS;
    }
}
