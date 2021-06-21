package patterns;

public abstract class LogonLogoffRequirement extends AuditPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Logon/Logoff";
    }
}
