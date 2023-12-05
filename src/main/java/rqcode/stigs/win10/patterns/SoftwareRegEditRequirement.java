package rqcode.stigs.win10.patterns;

public abstract class SoftwareRegEditRequirement extends RegistryEditRequirement {
    @Override
    public String checktext() {
        return getCheckTextAdditional() + getCheckTextBody();
    }

    @Override
    public String fixtext() {
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