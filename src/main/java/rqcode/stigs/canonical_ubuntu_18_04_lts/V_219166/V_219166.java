package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219166;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuScriptPattern;

/**
 * The Ubuntu operating system must be configured so that three consecutive invalid logon attempts 
 * by a user automatically locks the account until released by an administrator.
 * 
 * # https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219166
 */

public class V_219166 extends UbuntuScriptPattern {
    
    public V_219166() {
        super("3 consecutive invalid logon attempts by a user automatically locks the account in Ubuntu.",
        "V_219166/check.sh");
    }
}