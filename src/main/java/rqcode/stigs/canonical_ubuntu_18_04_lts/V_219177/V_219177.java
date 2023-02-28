package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219177;



import rqcode.concepts.Checkable;
import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * The Ubuntu operating system must not have the telnet package installed.
 * Passwords need to be protected at all times, and encryption is the standard method for protecting passwords. If passwords are not encrypted, they can be plainly read (i.e., clear text) and easily compromised.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219177
 */

public class V_219177 implements Checkable {
    
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("telnetd", false);

    
    public CheckStatus check() {
        return _package.check();
    }

    
    public String toString() {
        return _package.toString();
    }

}
