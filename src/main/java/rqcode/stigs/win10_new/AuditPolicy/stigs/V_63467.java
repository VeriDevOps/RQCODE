package rqcode.stigs.win10_new.AuditPolicy.stigs;

import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyConst;
import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyPattern;
import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyScriptPattern;
import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

import java.util.Map;

public class V_63467 extends AuditPolicyPattern {
    private final STIGScriptPattern policyScriptPattern =
            new AuditPolicyScriptPattern(
                    AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_CHECK, AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "guid", "{0CCE9216-69AE-11D9-BED3-505054503030}",
                            "checkValue", "success"
                    ),
                    Map.of(
                            "guid", "{0CCE9216-69AE-11D9-BED3-505054503030}",
                            "parameter", "success",
                            "value", "enable"));

    public V_63467() {
        pattern = this.policyScriptPattern;
    }
}