package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219163;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuScriptPattern;

/**
 * The Ubuntu operating system must be configured such that 
 * Pluggable Authentication Module (PAM) prohibits the use of cached authentications after one day.
 * 
 * # https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219163
 */

public class V_219163 extends UbuntuScriptPattern {
        
    public V_219163() {
        super("Ubuntu's PAM prohibits the use of cached authentications after one day.",
        "V_219163/check.sh");
    }
}