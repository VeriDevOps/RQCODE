package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219149;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuScriptPattern;

/**
 * The Ubuntu operating system must initiate session audits at system startup.
 * 
 * # https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219149
 */

public class V_219149 extends UbuntuScriptPattern {
        
    public V_219149() {
        super("Ubuntu OS must initiate session audits at system startup.",
        "V_219149/check.sh");
    }
}