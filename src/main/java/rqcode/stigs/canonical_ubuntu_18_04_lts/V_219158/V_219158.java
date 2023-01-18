package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219158;

import rqcode.concepts.Checkable;
import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuPackagePattern;

/**
 * The Ubuntu operating system must not have the rsh-server package installed.
 * 
 * It is detrimental for Ubuntu operating systems to provide, or install by
 * default, functionality exceeding requirements or mission objectives. These
 * unnecessary capabilities or services are often overlooked and therefore may
 * remain unsecured. They increase the risk to the platform by providing
 * additional attack vectors. Ubuntu operating systems are capable of providing
 * a wide variety of functions and services. Some of the functions and services,
 * provided by default, may not be necessary to support essential organizational
 * operations (e.g., key missions, functions). The rsh-server service provides
 * an unencrypted remote access service that does not provide for the
 * confidentiality and integrity of user passwords or the remote session and has
 * very weak authentication. If a privileged user were to log on using this
 * service, the privileged user password could be compromised.
 * 
 * https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219158
 */

public class V_219158 extends UbuntuPackagePattern {

    public V_219158() {
        super("rsh-server", false);
    }
}
