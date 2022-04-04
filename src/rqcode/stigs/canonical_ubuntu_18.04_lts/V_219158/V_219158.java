package rqcode.stigs.ubuntu.V_219158;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import rqcode.concepts.Checkable;
import rqcode.concepts.Checkable.CheckStatus;
import rqcode.stigs.ubuntu.UbuntuPackagePattern;

/**
 * It is detrimental for Ubuntu operating systems to provide, or install by default, functionality exceeding requirements or mission objectives. These unnecessary capabilities or services are often overlooked and therefore may remain unsecured. They increase the risk to the platform by providing additional attack vectors. Ubuntu operating systems are capable of providing a wide variety of functions and services. Some of the functions and services, provided by default, may not be necessary to support essential organizational operations (e.g., key missions, functions). The rsh-server service provides an unencrypted remote access service that does not provide for the confidentiality and integrity of user passwords or the remote session and has very weak authentication. If a privileged user were to log on using this service, the privileged user password could be compromised.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219158
 */
@objid ("1c36845a-46fd-4930-b75d-c557d73819f7")
public class V_219158 implements Checkable {
    @objid ("f28bbb9a-eb78-470d-848a-6f602e13c9b3")
    private UbuntuPackagePattern _package = new UbuntuPackagePattern("rsh-server", false);

    @objid ("eb20c4c7-511a-4c36-b4b6-91888c9212a9")
    public CheckStatus check() {
        return _package.check();
    }

    @objid ("2e9c8eeb-aac4-44d4-a2c7-64eef1b0c7c8")
    public String toString() {
        return _package.toString();
    }

}
