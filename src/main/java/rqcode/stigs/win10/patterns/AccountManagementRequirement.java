package rqcode.stigs.win10.patterns;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * General STIG requirement pattern for checking settings of Win10 User Account Management functionality.
 */

public abstract class AccountManagementRequirement extends AuditPolicyRequirement {
    
    @Override
    protected String getCategory() {
        return "Account Management";
    }

}
