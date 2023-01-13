package rqcode.concepts;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Implementations of this interface are requirements that can enforced on the hosting environment programmatically through the enforce function.
 */

public interface Enforceable {
    /**
     * Modifies the hosting environment to satisfy the requirement.
     * @return The outcome of the enforcement process or whether it was unable to complete.
     */
    
    EnforcementStatus enforce();

    
    public enum EnforcementStatus {
        
        SUCCESS,
        
        FAILURE,
        
        INCOMPLETE;

    }

}
