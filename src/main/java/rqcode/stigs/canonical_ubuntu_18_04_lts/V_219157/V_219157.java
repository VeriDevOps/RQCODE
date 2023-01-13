package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219157;



import rqcode.concepts.Checkable;
import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * Removing the Network Information Service (NIS) package decreases the risk of the accidental (or intentional) activation of NIS or NIS+ services.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219157
 */

public class V_219157 implements Checkable {
    
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("nis", false);

    
    public CheckStatus check() {
        return _package.check();
    }

    
    public String toString() {
        return _package.toString();
    }

}
