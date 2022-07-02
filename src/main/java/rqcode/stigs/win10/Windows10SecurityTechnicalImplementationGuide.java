package rqcode.stigs.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.concepts.CheckableEnforceableRequirement;

/**
 * This is example of the instantiation of the Win 10 STIG requirements.
 */
@objid ("838c1d01-3219-4ada-993c-85a2e8e0edd6")
public class Windows10SecurityTechnicalImplementationGuide {
    @objid ("c8bf7551-de18-43d4-aeaa-890ff5761756")
    public static final CheckableEnforceableRequirement v_63447 = new V_63447();

    @objid ("c9d87472-caf7-495e-88db-5b0f03852579")
    public static final CheckableEnforceableRequirement v_63779 = new V_63449();

    @objid ("e483dd1b-dea1-469f-a0eb-26d65f9d1ef8")
    public static final CheckableEnforceableRequirement v_63463 = new V_63463();

    @objid ("0c2efefa-59ae-412d-a5d8-66f6b90e4b3c")
    public static final CheckableEnforceableRequirement v_63467 = new V_63467();

    public static final CheckableEnforceableRequirement v_63843 = new V_63843();

    public static final CheckableEnforceableRequirement v_63851 = new V_63851();

    public static final CheckableEnforceableRequirement v_63863 = new V_63863();

    public static final CheckableEnforceableRequirement v_63931 = new V_63931();

    public static final CheckableEnforceableRequirement v_63647 = new V_63647 ();

    public static final CheckableEnforceableRequirement v_63703 = new V_63703 ();

    public static final CheckableEnforceableRequirement v_63321 = new V_63321 ();

    public static final CheckableEnforceableRequirement v_63709 = new V_63709 ();

    public static final CheckableEnforceableRequirement v_63423 = new V_63423 ();
    public static final CheckableEnforceableRequirement v_63427 = new V_63427 ();
    public static final CheckableEnforceableRequirement v_63405 = new V_63405 ();
    public static final CheckableEnforceableRequirement v_63409 = new V_63409 ();

    public static final CheckableEnforceableRequirement v_77091 = new V_77091 ();
    public static final CheckableEnforceableRequirement v_77095 = new V_77095 ();
    public static final CheckableEnforceableRequirement v_77103 = new V_77103 ();
    public static final CheckableEnforceableRequirement v_77189 = new V_77189 ();

    @objid ("816ff883-0fa7-4dc4-a2d0-55b39f91116a")
    public static CheckableEnforceableRequirement[] allSTIGs() {
        CheckableEnforceableRequirement[] retArr = {
            v_63447,
            v_63779,
            v_63467,
            v_63779,
            v_63843,
            v_63851,
            v_63863,
            v_63931,
            v_63647,
            v_63703,
            v_63321,
            v_63423,
            v_63427,
            v_63405,
            v_63409,
            v_63709,
            v_77091,
            v_77095,
            v_77103,
            v_77189,
        };
        return retArr;
    }

}
