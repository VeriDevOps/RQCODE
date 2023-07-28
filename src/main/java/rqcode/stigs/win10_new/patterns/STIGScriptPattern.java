package rqcode.stigs.win10_new.patterns;

public interface STIGScriptPattern {
    public String prepareEnforceScript();

    public String prepareCheckScript();

    public String getSettingName();

    public String getSettingValue();

    public String getSettingValueType();

}
