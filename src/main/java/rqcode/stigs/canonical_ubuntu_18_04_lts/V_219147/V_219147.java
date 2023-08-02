package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219147;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuScriptPattern;

/**
 * Ubuntu operating systems booted with a BIOS must require authentication upon booting into single-user and maintenance modes.
 * 
 * # https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219147
 */

public class V_219147 extends UbuntuScriptPattern {
 
    public V_219147() {
        super("Ubuntu booted with a BIOS must require authentication upon booting into single-user and maintenance modes.", 
        "V_219147/check.sh");
    }
}