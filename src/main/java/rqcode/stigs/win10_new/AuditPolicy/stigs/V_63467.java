package rqcode.stigs.win10_new.AuditPolicy.stigs;

import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyPattern;
import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyScriptPattern;
import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

import static rqcode.stigs.win10_new.AuditPolicy.AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_CHECK;
import static rqcode.stigs.win10_new.AuditPolicy.AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE;

public class V_63467 extends AuditPolicyPattern {
    private final AuditPolicyScriptPattern pattern =
            new AuditPolicyScriptPattern(AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE,
                    AUDIT_POLICY_SCRIPT_PATTERN_CHECK,
                    "{0CCE9216-69AE-11D9-BED3-505054503030}",
                    "success",
                    "enable");


    @Override
    public STIGScriptPattern pattern() {
        return pattern;
    }
}