package rqcode.stigs.win10.patterns;

public abstract class AccountLockoutPolicy extends SecurityPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Account Lockout Policy";
    }

    @Override
    protected Integer getCommandKey() {
        return 1;
    }
}
