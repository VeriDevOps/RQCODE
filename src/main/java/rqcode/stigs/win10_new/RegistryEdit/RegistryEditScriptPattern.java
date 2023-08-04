package rqcode.stigs.win10_new.RegistryEdit;

import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

import java.util.Map;

public class RegistryEditScriptPattern extends STIGScriptPattern {
    public RegistryEditScriptPattern(String checkScript, String enforceScript, Map<String, String> checkValues, Map<String, String> enforceValues) {
        super(checkScript, enforceScript, checkValues, enforceValues);
    }
}