package rqcode.stigs.win10_new.AuditPolicy;

public class AuditPolicyConst {
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE = "auditpol /set /subcategory:\"%(guid)\" /%(parameter):%(value)";
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_CHECK = "auditpol /get /subcategory:\"%(guid)\"";
}