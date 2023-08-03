package rqcode.stigs.win10_new.AuditPolicy;
import org.junit.Test;
import rqcode.concepts.Checkable;

import static org.junit.Assert.assertEquals;

public class CheckStatusTest {

    @Test
    public void testCheckStatusPass() {
        Checkable.CheckStatus status = Checkable.CheckStatus.PASS;
        assertEquals("Expected CheckStatus to be PASS", status, Checkable.CheckStatus.PASS);
    }

    @Test
    public void testCheckStatusFail() {
        Checkable.CheckStatus status = Checkable.CheckStatus.FAIL;
        assertEquals("Expected CheckStatus to be FAIL", status, Checkable.CheckStatus.FAIL);
    }

    @Test
    public void testCheckStatusIncomplete() {
        Checkable.CheckStatus status = Checkable.CheckStatus.INCOMPLETE;
        assertEquals("Expected CheckStatus to be INCOMPLETE", status, Checkable.CheckStatus.INCOMPLETE);
    }
}
