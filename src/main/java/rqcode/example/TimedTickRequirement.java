package rqcode.example;

import rqcode.concepts.Requirement;
import rqcode.temporal_patterns.GlobalUniversalityTimed;

/**
 * This class demonstrates the combination of RQCODE requirements and temporal patterns.
 */
public class TimedTickRequirement extends Requirement {

    GlobalUniversalityTimed ttr;

    public TimedTickRequirement() {
        TickRequirement tr = new TickRequirement();
        ttr = new GlobalUniversalityTimed(tr, 10);
        setStatement(ttr.toString());
    }

    @Override
    public CheckStatus check() {
        return ttr.check();
    }    
}
