package rqcode.example;

import rqcode.concepts.Requirement;

/**
 * This class is a reuse example of two RQCODE requirements by an association.
 * 
 */

public class ReuseByAssociation extends Requirement {

    TickRequirement tr;
    BoundaryRequirement br;

    public ReuseByAssociation()  {
        super("The Clock must satisfy the tick increment (REQ1) and seconds boundary (REQ2) requirements.");
        tr = new TickRequirement();
        br = new BoundaryRequirement();
    }

    @Override
    public CheckStatus check() {
        if (tr.check()== CheckStatus.FAIL) return CheckStatus.FAIL;
        if (br.check()== CheckStatus.FAIL) return CheckStatus.FAIL;
        return CheckStatus.PASS;
    }
}
