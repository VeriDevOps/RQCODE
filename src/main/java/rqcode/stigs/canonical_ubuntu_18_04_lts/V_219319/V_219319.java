package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219319;

import rqcode.concepts.Checkable;
import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * The use of PIV credentials facilitates standardization and reduces the risk of unauthorized access. DoD has mandated the use of the CAC to support identity management and personal authentication for systems covered under Homeland Security Presidential Directive (HSPD) 12, as well as making the CAC a primary component of layered protection for national security systems.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219319
 */

public class V_219319 extends UbuntuPackagePattern {

    public V_219319() {
        super("opensc-pkcs11", true);
    }
}