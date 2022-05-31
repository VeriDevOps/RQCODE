package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219177;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.concepts.Checkable;
import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * Passwords need to be protected at all times, and encryption is the standard method for protecting passwords. If passwords are not encrypted, they can be plainly read (i.e., clear text) and easily compromised.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219177
 */
@objid ("97dff0da-5fc6-4c09-8904-56961e84e628")
public class V_219177 implements Checkable {
    @objid ("15b1b197-2962-41ff-bd3c-4a8482886a7e")
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("telnetd", false);

    @objid ("97963e92-f7ad-4261-8a4c-59dd477100e7")
    public CheckStatus check() {
        return _package.check();
    }

    @objid ("241c7826-b117-46d0-a285-4f4c6011cb32")
    public String toString() {
        return _package.toString();
    }

}
