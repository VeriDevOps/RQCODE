package rqcode.stigs.win10_new.patterns;

import java.util.Map;

public abstract class STIGScriptPattern {

    private final String checkScript;
    private final String enforceScript;
    private final Map<String, String> checkValues;
    private final Map<String, String> enforceValues;

    public STIGScriptPattern(String checkScript, String enforceScript, Map<String, String> checkValues, Map<String, String> enforceValues) {
        this.checkScript = checkScript;
        this.enforceScript = enforceScript;
        this.checkValues = checkValues;
        this.enforceValues = enforceValues;
    }

    public String prepareEnforceScript() {
        return STIGScriptUtils.format(enforceScript, enforceValues);
    }

    public String prepareCheckScript() {
        return STIGScriptUtils.format(checkScript, checkValues);
    }

    public Map<String, String> getEnforceValues() {
        return enforceValues;
    }

    public Map<String, String> getCheckValues() {
        return checkValues;
    }
}
