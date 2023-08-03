package rqcode.stigs.win10_new.RegistryEdit;

import rqcode.stigs.win10_new.patterns.STIGPattern;

import java.util.Map;

public class RegistryEditPattern extends STIGPattern {

    @Override
    public boolean checkProcess(String script, Map<String, String> settingValues) throws Exception {
        return false;
    }
}