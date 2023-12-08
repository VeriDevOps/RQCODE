package rqcode.stigs.win10.patterns;

public abstract class PasswordPolicy extends SecurityPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Password Policy";
    }

    @Override
    public String checktext() {
        return CHECK_TEXT_TEMPLATE + getCategory() + getCheckTextAdditional();
    }

    @Override
    public String fixtext() {
        return FIX_TEXT_TEMPLATE + getCategory() + " >> " + getOption() + " to " + getInclusionSetting() + getFixTextAdditional();
    }
}
