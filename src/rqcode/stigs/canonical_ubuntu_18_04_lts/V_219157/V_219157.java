package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219157;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import rqcode.concepts.Checkable;
import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * Removing the Network Information Service (NIS) package decreases the risk of the accidental (or intentional) activation of NIS or NIS+ services.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219157
 */
@objid ("8f1cb863-2f1c-4249-848d-c35cde910ebd")
public class V_219157 implements Checkable {
    @objid ("18fc05f1-f81e-4a17-a5b0-68cc87d1aff4")
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("nis", false);

    @objid ("9de4ff53-fd08-4e7c-beda-22a18e321c69")
    public CheckStatus check() {
        return _package.check();
    }

    @objid ("7d9f522b-2765-427c-a106-5cb2b0e0a026")
    public String toString() {
        return _package.toString();
    }

}
