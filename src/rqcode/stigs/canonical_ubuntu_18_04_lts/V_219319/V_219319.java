package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219319;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import rqcode.concepts.Checkable;
import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * The use of PIV credentials facilitates standardization and reduces the risk of unauthorized access. DoD has mandated the use of the CAC to support identity management and personal authentication for systems covered under Homeland Security Presidential Directive (HSPD) 12, as well as making the CAC a primary component of layered protection for national security systems.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219319
 */
@objid ("2ca78b60-2421-4114-8c45-9717e40f14b2")
public class V_219319 implements Checkable {
    @objid ("cf6771ff-2717-45eb-bb28-bfefcea829f5")
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("opensc-pkcs11", true);

    @objid ("982d70bd-ab20-4ef3-bf7b-2093eeba434f")
    public CheckStatus check() {
        return _package.check();
    }

    @objid ("70ead19d-ee26-49cf-925d-c6598e132a49")
    public String toString() {
        return _package.toString();
    }

}
