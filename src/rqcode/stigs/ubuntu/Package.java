package rqcode.stigs.ubuntu;

import rqcode.concepts.Checkable;
import java.io.*;

public class Package implements Checkable {
    private String _name;
    private boolean _mustBeInstalled;
    public Package (String name, boolean mustBeInstalled) {
        _name = name;
        _mustBeInstalled = mustBeInstalled;
    }

    public CheckStatus check() {    
        Process process = null;    
        try {
            process = Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/rqcode/stigs/ubuntu/package.sh " + _name);
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
        if ((process.exitValue() != 0) && _mustBeInstalled) {
            return CheckStatus.FAIL;
        }
        if ((process.exitValue() == 0) && !_mustBeInstalled) {
            return CheckStatus.FAIL;
        }        
        return CheckStatus.PASS;
    }
}
