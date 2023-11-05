package rqcode.stigs.win10_new.AuditPolicy.stigs.forparser;

import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyConst;
import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyPattern;
import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyScriptPattern;
import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

import java.util.Map;

public class StigTemplate extends AuditPolicyPattern {
    private final STIGScriptPattern policyScriptPattern;

    public StigTemplate(String guid, String checkValue) {
        policyScriptPattern = new AuditPolicyScriptPattern(
                AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_CHECK, AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE,
                Map.of(
                        "guid", guid,
                        "checkValue", checkValue
                ),
                Map.of(
                        "guid", guid,
                        "checkValue", checkValue,
                        "value", "enable"
                )
        );
        pattern = this.policyScriptPattern;
    }
}
