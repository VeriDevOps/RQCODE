package rqcode.stigs.win10.patterns;



/**
 * General STIG requirement pattern for checking settings of Win10 Privilege Use policies.
 */

public abstract class PrivilegeUseRequirement extends AuditPolicyRequirement {
    
    @Override
    protected String getCategory() {
        return "Privilege Use";
    }

}
