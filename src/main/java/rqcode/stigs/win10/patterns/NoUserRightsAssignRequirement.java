package rqcode.stigs.win10.patterns;

public abstract class NoUserRightsAssignRequirement extends UserRightsRequirement {
    @Override
    protected String getFixTextAdditional() {
        return " to be defined but containing no entries (blank).";
    }

    @Override
    protected String getCheckTextAdditional() {
        return ", this is a finding.";
    }

    @Override
    protected String getInclusionSetting() {
        return "null";
    }

    @Override
    protected String getGrantUserRights() {
        return "";
    }
}
