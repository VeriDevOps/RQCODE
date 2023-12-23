package rqcode.stigs.win10_new.Categories;
import org.junit.Test;
import rqcode.concepts.Enforceable;

import static org.junit.Assert.assertEquals;

public class EnforcementStatusTest {

    @Test
    public void testEnforcementStatusSuccess() {
      Enforceable.EnforcementStatus status = Enforceable.EnforcementStatus.SUCCESS;
        assertEquals("Expected EnforcementStatus to be SUCCESS", status, Enforceable.EnforcementStatus.SUCCESS);
    }

    @Test
    public void testEnforcementStatusFailure() {
        Enforceable.EnforcementStatus status = Enforceable.EnforcementStatus.FAILURE;
        assertEquals("Expected EnforcementStatus to be FAILURE", status, Enforceable.EnforcementStatus.FAILURE);
    }

}

