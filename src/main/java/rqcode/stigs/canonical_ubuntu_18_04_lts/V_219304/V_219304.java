package main.java.rqcode.stigs.canonical_ubuntu_18_04_lts.V_219304;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import main.java.rqcode.concepts.Checkable;
import main.java.rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * A session lock is a temporary action taken when a user stops work and moves away from the immediate physical vicinity of the information system but does not want to log out because of the temporary nature of the absence. The session lock is implemented at the point where session activity can be determined. Rather than be forced to wait for a period of time to expire before the user session can be locked, the Ubuntu operating system need to provide users with the ability to manually invoke a session lock so users may secure their session should the need arise for them to temporarily vacate the immediate physical vicinity. Satisfies: SRG-OS-000030-GPOS-00011, SRG-OS-000031-GPOS-00012.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219304
 */
@objid ("f978b0a3-6ca5-46fd-bb68-c2a793f0907b")
public class V_219304 implements Checkable {
    @objid ("94deadb5-8b99-40f1-ac2c-aba68af9112a")
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("vlock", true);

    @objid ("0300a697-27d1-4b67-8b91-6e48da29fea8")
    public CheckStatus check() {
        return _package.check();
    }

    @objid ("a48c6807-75b5-4d7a-8814-67e5de67053b")
    public String toString() {
        return _package.toString();
    }

}
