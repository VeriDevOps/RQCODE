package rqcode.patterns.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * General STIG requirement pattern for checking settings of Win10 User Account Management functionality.
 */
@objid ("23249d2d-62f7-437f-8efb-577ba0ccbc9f")
public abstract class AccountManagementRequirement extends AuditPolicyRequirement {
    @objid ("b20b7e88-7bdd-4536-ab57-491880dcf7e7")
    @Override
    protected String getCategory() {
        return "Account Management";
    }

}
