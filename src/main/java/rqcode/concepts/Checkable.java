package rqcode.concepts;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Implementations of this interface are requirements that can be checked programmatically through the check function.
 */

public interface Checkable {
    /**
     * Checks whether the current environment satisfies the requirement of not.
     * @return The result of the check or whether the check was unable to be complete.
     */
    
    CheckStatus check();

    
    public enum CheckStatus {
        
        PASS,
        
        FAIL,
        
        INCOMPLETE;

    }

}