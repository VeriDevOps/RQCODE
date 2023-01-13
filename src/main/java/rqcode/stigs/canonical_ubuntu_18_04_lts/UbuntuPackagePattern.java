package rqcode.stigs.canonical_ubuntu_18_04_lts;

import java.io.IOException;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.concepts.Enforceable;
import rqcode.concepts.Requirement;

/**
 * RQCODE security requirements pattern from STIGS repository.
 */

public class UbuntuPackagePattern extends Requirement implements Enforceable {
    
    private String _name;

    
    private boolean _mustBeInstalled;

    
    public  UbuntuPackagePattern(String name, boolean mustBeInstalled) {
        _name = name;
        _mustBeInstalled = mustBeInstalled;

        setStatement(this.toString());
    }

    
    public CheckStatus check() {
        Process process = null;    
        try {
            process = Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/java/rqcode/stigs/canonical_ubuntu_18_04_lts/package.sh " + _name);
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

    
    public String toString() {
        String ret = "";
        ret += "The Ubuntu operating system must ";
        if (!_mustBeInstalled) {
            ret += "not ";
        }
        ret += "have the " + _name + " package installed.";
        return ret;
    }

    
    public EnforcementStatus enforce() {
        Process process = null;    
        String action = _mustBeInstalled ? "install " : "remove ";
        try {
            process = Runtime.getRuntime().exec("sudo apt-get " + action + _name);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            return EnforcementStatus.INCOMPLETE;
        }
        try {
            process.waitFor();
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException.getMessage());
            return EnforcementStatus.INCOMPLETE;
        }        
        return EnforcementStatus.SUCCESS;
    }

}
