package rqcode.stigs.win10.patterns;

import java.util.Map;

/**
 * General STIG requirement pattern for checking settings of Win10 User Account Management functionality.
 */

public abstract class AccountManagementRequirement extends AuditPolicyRequirement {
    
    public AccountManagementRequirement(Map<String, String> stigInfo) {
        super(stigInfo);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected String getCategory() {
        return "Account Management";
    }

}
