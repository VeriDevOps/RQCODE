package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219157;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * The Ubuntu operating system must not have the Network Information Service
 * (NIS) package installed.
 * 
 * Removing the Network Information Service (NIS) package decreases the risk of
 * the accidental (or intentional) activation of NIS or NIS+ services.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219157
 */

public class V_219157 extends UbuntuPackagePattern {

    public V_219157() {
        super("nis", false);
    }
}
