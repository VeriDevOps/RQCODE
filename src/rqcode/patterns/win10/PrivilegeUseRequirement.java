package rqcode.patterns.win10;

abstract public class PrivilegeUseRequirement extends AuditPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Privilege Use";
    }
}