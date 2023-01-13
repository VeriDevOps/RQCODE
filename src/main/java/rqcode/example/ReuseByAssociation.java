package rqcode.example;

import rqcode.concepts.Requirement;

/**
 * This class is a reuse example of two RQCODE requirements by an association.
 * 
 */

public class ReuseByAssociation extends Requirement {

    public ReuseByAssociation()  {
        super("The Clock must satisfy the tick increment (REQ1) and seconds boundary (REQ2) requirements.");
    }

    @Override
    public CheckStatus check() {
        TickRequirement tr = new TickRequirement();
        if (tr.check()== CheckStatus.FAIL) return CheckStatus.FAIL;
        BoundaryRequirement br = new BoundaryRequirement();
        if (br.check()== CheckStatus.FAIL) return CheckStatus.FAIL;
        return CheckStatus.PASS;
    }
}
