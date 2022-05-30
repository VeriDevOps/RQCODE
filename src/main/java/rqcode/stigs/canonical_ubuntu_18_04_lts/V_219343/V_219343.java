package main.java.rqcode.stigs.canonical_ubuntu_18_04_lts.V_219343;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import main.java.rqcode.concepts.Checkable;
import main.java.rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * Without verification of the security functions, security functions may not operate correctly and the failure may go unnoticed. Security function is defined as the hardware, software, and/or firmware of the information system responsible for enforcing the system security policy and supporting the isolation of code and data on which the protection is based. Security functionality includes, but is not limited to, establishing system accounts, configuring access authorizations (i.e., permissions, privileges), setting events to be audited, and setting intrusion detection parameters. This requirement applies to the Ubuntu operating system performing security function verification/testing and/or systems and environments that require this functionality.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219343
 */
@objid ("b4156a11-7c63-4033-93c2-841e3198fbb9")
public class V_219343 implements Checkable {
    @objid ("cda6b747-1445-4aec-95eb-21a14109264c")
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("aide", true);

    @objid ("c3ffb434-7670-4a45-905b-51ed71ab0a60")
    public CheckStatus check() {
        return _package.check();
    }

    @objid ("1b0c36ad-178a-404b-bcb8-b0c2c5369f0b")
    public String toString() {
        return _package.toString();
    }

}
