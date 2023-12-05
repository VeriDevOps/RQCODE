package rqcode.stigs.win10_new.AuditPolicy;

import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

import java.util.Map;

public class AuditPolicyScriptPattern extends STIGScriptPattern {

    public AuditPolicyScriptPattern(String checkScript, String enforceScript, Map<String, String> checkValues, Map<String, String> enforceValues, Map<String, String> additionalInfo) {
        super(checkScript, enforceScript, checkValues, enforceValues, additionalInfo);
    }
}