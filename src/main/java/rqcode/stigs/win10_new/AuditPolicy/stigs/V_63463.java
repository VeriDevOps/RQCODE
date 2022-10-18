package rqcode.stigs.win10_new.AuditPolicy.stigs;

import rqcode.patterns.win10_new.STIGScriptPattern;
import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyPattern;
import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyScriptPattern;

import static rqcode.stigs.win10_new.AuditPolicy.AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN;

public class V_63463 extends AuditPolicyPattern {
    private final AuditPolicyScriptPattern pattern =
            new AuditPolicyScriptPattern(AUDIT_POLICY_SCRIPT_PATTERN, "{0CCE9216-69AE-11D9-BED3-505054503030}", "failure", "enable");


    @Override
    public STIGScriptPattern pattern() {
        return pattern;
    }
}