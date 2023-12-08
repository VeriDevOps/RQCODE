package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219343;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * Without verification of the security functions, security functions may not operate correctly and the failure may go unnoticed. Security function is defined as the hardware, software, and/or firmware of the information system responsible for enforcing the system security policy and supporting the isolation of code and data on which the protection is based. Security functionality includes, but is not limited to, establishing system accounts, configuring access authorizations (i.e., permissions, privileges), setting events to be audited, and setting intrusion detection parameters. This requirement applies to the Ubuntu operating system performing security function verification/testing and/or systems and environments that require this functionality.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219343
 */

public class V_219343 extends UbuntuPackagePattern {

    public V_219343() {
        super("aide", true);
    }
}
