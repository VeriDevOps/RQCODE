package rqcode.patterns.win10;

public abstract class PasswordPolicy extends SecurityPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Password Policy";
    }

    @Override
    public String checkText() {
        return CHECK_TEXT_TEMPLATE + getCategory() + getCheckTextAdditional();
    }

    @Override
    public String fixText() {
        return FIX_TEXT_TEMPLATE + getCategory() + " >> " + getOption() + " to " + getInclusionSetting() + getFixTextAdditional();
    }
}
