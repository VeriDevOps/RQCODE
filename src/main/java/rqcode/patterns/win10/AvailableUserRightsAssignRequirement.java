package rqcode.patterns.win10;

// implementation of subcategory that  assigns User Rights
public abstract class AvailableUserRightsAssignRequirement extends UserRightsAssignRequirement {
    @Override
    protected String getSubcategory() {
        return "Available User Rights Assignment";
    }

    @Override
    public String checkText() {
        return "Verify the effective setting in Local Group Policy Editor.\n" +
                "Run \"gpedit.msc\".\n" +
                "\n" +
                "Navigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment." +
                "\n" + String.format("If any groups or accounts other than the following are granted the \"%s\" user right, this is a finding:", getInclusionSetting()) +
                "\n" + getRights();
    }

    @Override
    public String fixText() {
        return String.format("Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"%s\" to only include the following groups or accounts:", getInclusionSetting());
    }

    public abstract String getRights();
}
