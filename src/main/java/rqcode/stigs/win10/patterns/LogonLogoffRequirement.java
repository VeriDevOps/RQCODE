package rqcode.stigs.win10.patterns;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * General STIG requirement pattern for checking settings of Win10 Logon and Logoff functionality.
 */

public abstract class LogonLogoffRequirement extends AuditPolicyRequirement {
    
    @Override
    protected String getCategory() {
        return "Logon/Logoff";
    }

}
