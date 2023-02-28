package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219304;



import rqcode.concepts.Checkable;
import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * The Ubuntu operating system must be configured for users to directly initiate a session lock for all connection types.
 * A session lock is a temporary action taken when a user stops work and moves away from the immediate physical vicinity of the information system but does not want to log out because of the temporary nature of the absence. The session lock is implemented at the point where session activity can be determined. Rather than be forced to wait for a period of time to expire before the user session can be locked, the Ubuntu operating system need to provide users with the ability to manually invoke a session lock so users may secure their session should the need arise for them to temporarily vacate the immediate physical vicinity. Satisfies: SRG-OS-000030-GPOS-00011, SRG-OS-000031-GPOS-00012.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219304
 */

public class V_219304 implements Checkable {
    
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("vlock", true);

    
    public CheckStatus check() {
        return _package.check();
    }

    
    public String toString() {
        return _package.toString();
    }

}
