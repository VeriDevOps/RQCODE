package rqcode.concepts;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.stigs.STIG;

/**
 * This is a combination of Checkable and Enforceable Requirement.
 */
@objid ("3bf7e5e9-b536-4aa7-9a31-7b6df7f3b5be")
public abstract class CheckableEnforceableRequirement extends STIG implements Checkable, Enforceable {
}
