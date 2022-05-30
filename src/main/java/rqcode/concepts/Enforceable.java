package main.java.rqcode.concepts;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Implementations of this interface are requirements that can enforced on the hosting environment programmatically through the enforce function.
 */
@objid ("74657906-e5db-4a54-8c6c-d755de03f71f")
public interface Enforceable {
    /**
     * Modifies the hosting environment to satisfy the requirement.
     * @return The outcome of the enforcement process or whether it was unable to complete.
     */
    @objid ("39e9142e-dd9f-4617-b847-a631ef6bb56b")
    EnforcementStatus enforce();

    @objid ("1b132ec1-8340-4bdd-b921-b80d5aad9b8b")
    public enum EnforcementStatus {
        @objid ("a6ef17ce-ee01-4948-b356-b525c4b1f3d8")
        SUCCESS,
        @objid ("dd4e57cb-7719-4710-bc43-d9f2f0d142f1")
        FAILURE,
        @objid ("3fc0518a-a27a-49e6-b9fb-62dd5d817275")
        INCOMPLETE;

    }

}
