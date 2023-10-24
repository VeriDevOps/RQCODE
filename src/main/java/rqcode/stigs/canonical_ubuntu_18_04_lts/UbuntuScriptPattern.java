package rqcode.stigs.canonical_ubuntu_18_04_lts;

import java.io.IOException;

import rqcode.concepts.Requirement;

/**
 * RQCODE security requirements pattern with executable shell script attached
 */

public class UbuntuScriptPattern extends Requirement {
    
    private String _name;
    private String _script;

    public UbuntuScriptPattern(String name, String script) {
        _name = name;
        _script = script;

        setStatement(this.toString());
    }
    
    public CheckStatus check() {
        Process process = null;    
        try {
            process = Runtime.getRuntime().exec("/src/main/java/rqcode/stigs/canonical_ubuntu_18_04_lts/" + _script);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            return CheckStatus.INCOMPLETE;
        }
        try {
            process.waitFor();
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException.getMessage());
            return CheckStatus.INCOMPLETE;
        }
        if (process.exitValue() != 0) {
            return CheckStatus.FAIL;
        }
        return CheckStatus.PASS;
    }

    public String toString() {
        return _name;
    }
}