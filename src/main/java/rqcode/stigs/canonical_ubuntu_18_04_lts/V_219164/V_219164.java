package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219164;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuScriptPattern;

/**
 * The Ubuntu operating system must enforce a delay of at least 4 seconds between logon prompts following a failed logon attempt.
 * 
 * # https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219164
 */

public class V_219164 extends UbuntuScriptPattern {

    public V_219164() {
        super("Ubuntu OS must enforce a delay of at least 4 seconds between logon prompts following a failed logon attempt.",
        "V_219164/check.sh");
    }
}