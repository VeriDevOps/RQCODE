package patterns;

abstract public class PrivilegeUseRequirement extends AuditPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Privilege Use";
    }
}