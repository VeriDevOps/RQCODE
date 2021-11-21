package rqcode.patterns.win10;

public abstract class LogonLogoffRequirement extends AuditPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Logon/Logoff";
    }
}
