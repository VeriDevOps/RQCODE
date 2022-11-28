package rqcode.stigs.win10_new.AuditPolicy;

public class AuditPolicyConst {
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE = "auditpol /set /subcategory:\"%s\" /%s:%s";
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_CHECK = "auditpol /set /subcategory:\"%s\"";
}