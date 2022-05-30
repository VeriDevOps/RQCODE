package main.java.rqcode.patterns.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * General STIG requirement pattern for checking settings of Win10 Logon and Logoff functionality.
 */
@objid ("5c72fbfe-953d-4e9b-a677-e6ecf54edf8a")
public abstract class LogonLogoffRequirement extends AuditPolicyRequirement {
    @objid ("19ad2e52-8843-4d06-8354-f9c5d16cf5e5")
    @Override
    protected String getCategory() {
        return "Logon/Logoff";
    }

}
