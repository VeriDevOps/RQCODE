package rqcode.stigs.win10_new.AuditPolicy.stigs;

import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyConst;
import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyPattern;
import rqcode.stigs.win10_new.AuditPolicy.AuditPolicyScriptPattern;
import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

import java.util.Map;

public class V_220752 extends AuditPolicyPattern {
private final STIGScriptPattern policyScriptPattern =
new AuditPolicyScriptPattern(
AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_CHECK, AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                        "id", "V_220752",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "subcat_es", "acierto",
                        "subcat_eng", "success"
                    ),
                    Map.of(
                        "id", "V_220752",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "parameter", "Success",
                        "value", "enable"
                        ),
                    Map.of(
                        "description", "The system must be configured to audit Account Management - User Account Management successes."
                        )
                );

public V_220752() {
pattern = this.policyScriptPattern;
}
}