package rqcode.stigs.win10_new.AuditPolicy;

import rqcode.patterns.win10_new.STIGScriptPattern;

public class AuditPolicyScriptPattern implements STIGScriptPattern {
    private String scriptBody;
    private String code;
    private String settingName;
    private String settingValue;

    public AuditPolicyScriptPattern(String scriptBody, String code, String settingName, String settingValue) {
        this.scriptBody = scriptBody;
        this.code = code;
        this.settingName = settingName;
        this.settingValue = settingValue;
    }

    @Override
    public String prepareScript() {
        return String.format(scriptBody, code, settingName, settingValue);
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