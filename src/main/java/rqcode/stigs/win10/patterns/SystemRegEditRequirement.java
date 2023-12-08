package rqcode.stigs.win10.patterns;

public abstract class SystemRegEditRequirement extends RegistryEditRequirement{
    @Override
    public String checktext() {
        return getCheckTextBody();
    }

    @Override
    public String fixtext() {
        return "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options >> "
                + getOption() + " to " + getInclusionSetting();
    }

    @Override
    protected String getInclusionSetting() {
        return "Enabled";
    }

    @Override
    protected String getValueType() {
        return "REG_DWORD";
    }

    @Override
    protected String getValue() {
        return "1";
    }
}
