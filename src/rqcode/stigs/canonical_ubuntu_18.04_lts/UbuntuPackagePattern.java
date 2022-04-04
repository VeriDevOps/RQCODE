package rqcode.stigs.ubuntu;

import java.io.*;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import rqcode.concepts.Checkable;
import rqcode.concepts.Checkable.CheckStatus;
import rqcode.concepts.Enforceable;
import rqcode.concepts.Enforceable.EnforcementStatus;

/**
 * RQCODE security requirements pattern from STIGS repository.
 */
@objid ("46ddfebe-b479-43d7-ac66-6355059584da")
public class UbuntuPackagePattern implements Checkable, Enforceable {
    @objid ("7f9bfdfd-c0d4-46be-bec9-5a9c48d8d881")
    private String _name;

    @objid ("00293a59-edbd-4ced-a21d-af62e44a8107")
    private boolean _mustBeInstalled;

    @objid ("8d05e3f7-7e78-4d63-90ba-7ab254f3de58")
    public  UbuntuPackagePattern(String name, boolean mustBeInstalled) {
        _name = name;
        _mustBeInstalled = mustBeInstalled;
    }

    @objid ("9c558a4a-041d-44a6-a0a5-91dd7ea10eb2")
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

    @objid ("5a1dc8ab-2561-43b3-85e8-373d6f7806be")
    public String toString() {
        String ret = "";
        ret += "The Ubuntu operating system must ";
        if (!_mustBeInstalled) {
            ret += "not ";
        }
        ret += "have the " + _name + " package installed.";
        return ret;
    }

    @objid ("3a6ff243-728e-49ac-b147-1906f1799bba")
    public EnforcementStatus enforce() {
        Process process = null;    
        var action = _mustBeInstalled ? "install " : "remove ";
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
