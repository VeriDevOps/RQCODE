package rqcode.stigs.win10.patterns;

public abstract class AvailableUserRightsAssignRequirement extends UserRightsRequirement {
    @Override
    protected String getFixTextAdditional() {
        return String.format("to only include the following groups or accounts: \n\n%s", getInclusionSetting());
    }

    @Override
    protected String getCheckTextAdditional() {
        return String.format(", this is a finding:\n\n%s", getInclusionSetting());
    }
}
