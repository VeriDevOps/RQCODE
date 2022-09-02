package rqcode.concepts;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Implementations of this interface are requirements that can be checked programmatically through the check function.
 */
@objid ("111730fe-edfd-4d16-bb51-8503832a3d5c")
public interface Checkable {
    /**
     * Checks whether the current environment satisfies the requirement of not.
     * @return The result of the check or whether the check was unable to be complete.
     */
    @objid ("6bda9775-ea96-484d-b457-749ee72b4efa")
    CheckStatus check();

    @objid ("8f66df5b-0cba-4b54-9972-df49c63bda82")
    public enum CheckStatus {
        @objid ("6ec82f28-b030-41f9-bc2f-84bf0dcad624")
        PASS,
        @objid ("bb29c847-a58a-4db3-8767-ac4c5e65f916")
        FAIL,
        @objid ("64adf409-5d94-41be-a275-c05bec36c719")
        INCOMPLETE;

    }

}