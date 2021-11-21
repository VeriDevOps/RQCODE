package rqcode.patterns.win10;

public abstract class AccountManagementRequirement extends AuditPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Account Management";
    }
}
