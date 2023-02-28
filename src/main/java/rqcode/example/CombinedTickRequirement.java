package rqcode.example;

import rqcode.concepts.Requirement;

/**
 * This class is a reuse example of two RQCODE requirements by an association.
 * 
 */

public class CombinedTickRequirement extends Requirement {
    TickIncrementRequirement tr;
    TickBoundaryRequirement br;
    public CombinedTickRequirement()  {
        super("The Clock must satisfy the tick increment (REQ1) and seconds boundary (REQ2) requirements.");
        tr = new TickIncrementRequirement();
        br = new TickBoundaryRequirement();
    }
    @Override
    public CheckStatus check() {
        if (br.check()== CheckStatus.FAIL) return CheckStatus.FAIL;
        return tr.check();
    }
}
