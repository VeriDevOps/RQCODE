package rqcode.stigs.canonical_ubuntu_18_04_lts.V_219160;

import rqcode.stigs.canonical_ubuntu_18_04_lts.UbuntuScriptPattern;

/**
 * The Ubuntu operating system must be configured to preserve log records from failure events.
 * 
 * # https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219160
 */

public class V_219160 extends UbuntuScriptPattern {
        
    public V_219160() {
        super("Ubuntu OS must be configured to preserve log records from failure events.",
         "V_219160/check.sh");
    }
}