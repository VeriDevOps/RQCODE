package rqcode.stigs.win10_new.RegistryEdit;

import rqcode.patterns.win10_new.STIGScriptPattern;

public class RegistryEditScriptPattern implements STIGScriptPattern {
    private String scriptBody;
    private String registryPath;
    private String name;
    private String type;
    private String value;

    public RegistryEditScriptPattern(String scriptBody, String registryPath, String name, String type, String value) {
        this.scriptBody = scriptBody;
        this.registryPath = registryPath;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    @Override
    public String prepareScript() {
        return String.format(scriptBody, registryPath, name, type, value);
    }

    @Override
    public String getSettingName() {
        return null;
    }

    @Override
    public String getSettingValue() {
        return null;
    }
}