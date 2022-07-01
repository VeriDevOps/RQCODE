package rqcode.patterns.win10;

public abstract class SoftwareRegEditRequirement extends RegistryEditRequirement {
    @Override
    public String checkText() {
        return getCheckTextAdditional() + getCheckTextBody();
    }

    @Override
    public String fixText() {
        return "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> " + getComponentName() + " >> "
                + getOption() + " to " + getInclusionSetting();
    }

    @Override
    protected String getInclusionSetting() {
        return "Disabled";
    }

    public abstract String getCheckTextAdditional();
    public abstract String getComponentName();
}