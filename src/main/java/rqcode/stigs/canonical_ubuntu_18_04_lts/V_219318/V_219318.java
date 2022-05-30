package main.java.rqcode.stigs.canonical_ubuntu_18_04_lts.V_219318;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import main.java.rqcode.concepts.Checkable;
import main.java.rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * Using an authentication device, such as a CAC or token that is separate from the information system, ensures that even if the information system is compromised, that compromise will not affect credentials stored on the authentication device. Multifactor solutions that require devices separate from information systems gaining access include, for example, hardware tokens providing time-based or challenge-response authenticators and smart cards such as the U.S. Government Personal Identity Verification card and the DoD Common Access Card. A privileged account is defined as an information system account with authorizations of a privileged user. Remote access is access to DoD nonpublic information systems by an authorized user (or an information system) communicating through an external, non-organization-controlled network. Remote access methods include, for example, dial-up, broadband, and wireless. This requirement only applies to components where this is specific to the function of the device or has the concept of an organizational user (e.g., VPN, proxy capability). This does not apply to authentication for the purpose of configuring the device itself (management). Requires further clarification from NIST.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219318
 */
@objid ("c671f27d-c30c-4d40-a19c-80aef9004426")
public class V_219318 implements Checkable {
    @objid ("5f516d36-6f25-4d6c-8353-5bb3b35788da")
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("libpam-pkcs11", true);

    @objid ("f38db186-9b0e-4fa9-a316-b1ba669a225a")
    public CheckStatus check() {
        return _package.check();
    }

    @objid ("e6d8452d-4572-4e7b-8a92-b1df3525dae7")
    public String toString() {
        return _package.toString();
    }

}
