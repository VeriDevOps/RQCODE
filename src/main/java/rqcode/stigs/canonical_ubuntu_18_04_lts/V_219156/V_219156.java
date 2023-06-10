package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219156;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuScriptPattern;

/**
 * The Ubuntu operating system must be configured so that Advance package Tool (APT) 
 * removes all software components after updated versions have been installed.
 * 
 * # https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219156
 */

public class V_219156 extends UbuntuScriptPattern {
        
    public V_219156() {
        super("Ubuntu's APT must remove all software components after update installation.",
        "V_219156/check.sh");
    }
}