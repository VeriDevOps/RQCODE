package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219148;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuScriptPattern;

/**
 * Ubuntu operating systems booted with United Extensible Firmware Interface (UEFI) implemented
 * must require authentication upon booting into single-user mode and maintenance.
 * 
 * # https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219148
 */

public class V_219148 extends UbuntuScriptPattern {
        
    public V_219148() {
        super("Ubuntu booted with a UEFI must require authentication upon booting into single-user and maintenance modes.",
        "V_219148/check.sh");
    }
}