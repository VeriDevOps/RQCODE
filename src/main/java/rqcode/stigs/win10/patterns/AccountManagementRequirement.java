package rqcode.stigs.win10.patterns;



/**
 * General STIG requirement pattern for checking settings of Win10 User Account Management functionality.
 */

public abstract class AccountManagementRequirement extends AuditPolicyRequirement {
    
    @Override
    protected String getCategory() {
        return "Account Management";
    }

}
