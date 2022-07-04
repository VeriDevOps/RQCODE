package rqcode.patterns.win10;

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
