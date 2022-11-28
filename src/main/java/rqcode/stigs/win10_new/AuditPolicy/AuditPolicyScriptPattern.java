package rqcode.stigs.win10_new.AuditPolicy;

import rqcode.patterns.win10_new.STIGScriptPattern;

public class AuditPolicyScriptPattern implements STIGScriptPattern {
    private String scriptEnforceBody;
    private String scriptCheckBody;
    private String code;
    private String settingName;
    private String settingValue;

    public AuditPolicyScriptPattern(String scriptEnforceBody, String scriptCheckBody,String code, String settingName, String settingValue) {
        this.scriptEnforceBody = scriptEnforceBody;
        this.scriptCheckBody = scriptCheckBody;
        this.code = code;
        this.settingName = settingName;
        this.settingValue = settingValue;
    }

    @Override
    public String prepareEnforceScript() {
        return String.format(scriptEnforceBody, code, settingName, settingValue);
    }

    @Override
    public String prepareCheckScript() {
        return String.format(scriptCheckBody, code);
    }

    @Override
    public String getSettingName() {
        return settingName;
    }

    @Override
    public String getSettingValue() {
        return settingValue;
    }


}