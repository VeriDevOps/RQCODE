package rqcode.stigs.win10.patterns;



/**
 * General STIG requirement pattern for checking settings of Win10 Logon and Logoff functionality.
 */

public abstract class LogonLogoffRequirement extends AuditPolicyRequirement {
    
    @Override
    protected String getCategory() {
        return "Logon/Logoff";
    }

}
