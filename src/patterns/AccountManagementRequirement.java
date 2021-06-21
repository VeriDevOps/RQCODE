package patterns;

public abstract class AccountManagementRequirement extends AuditPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Account Management";
    }
}
