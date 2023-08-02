package rqcode.stigs.win10_new.RegistryEdit;

import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

public class RegistryEditScriptPattern implements STIGScriptPattern {
    private String scriptBody;

    private String checkScriptBody;
    private String registryPath;
    private String name;
    private String type;
    private String value;

    public RegistryEditScriptPattern(String scriptBody, String checkScriptBody,  String registryPath, String name, String type, String value) {
        this.scriptBody = scriptBody;
        this.checkScriptBody = checkScriptBody;
        this.registryPath = registryPath;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    @Override
    public String prepareEnforceScript() {
        return String.format(scriptBody, registryPath, name, type, value);
    }

    @Override
    public String prepareCheckScript() {
        return String.format(checkScriptBody, registryPath, name, type, value);
    }

    @Override
    public String getSettingName() {
        return null;
    }

    @Override
    public String getSettingValue() {
        return value;
    }
}