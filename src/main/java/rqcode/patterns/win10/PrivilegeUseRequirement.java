package main.java.rqcode.patterns.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * General STIG requirement pattern for checking settings of Win10 Privilege Use policies.
 */
@objid ("56e14ee7-8f5d-48b8-8395-d7b8f3cc8308")
public abstract class PrivilegeUseRequirement extends AuditPolicyRequirement {
    @objid ("3283a1ea-0ae5-4550-8bef-fd6af7368372")
    @Override
    protected String getCategory() {
        return "Privilege Use";
    }

}
