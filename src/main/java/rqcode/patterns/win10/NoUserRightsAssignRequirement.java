package rqcode.patterns.win10;

// implementation of subcategory that does not assign User Rights
public abstract class NoUserRightsAssignRequirement extends UserRightsAssignRequirement {
    @Override
    protected String getSubcategory() {
        return "No User Rights Assignment";
    }

    @Override
    public String checkText() {
        return "Verify the effective setting in Local Group Policy Editor.\n" +
                "Run \"gpedit.msc\".\n" +
                "\n" +
                "Navigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment." +
                "\n" + String.format("If any groups or accounts are granted the \"%s\" user right, this is a finding.", getInclusionSetting());
    }

    @Override
    public String fixText() {
        return String.format("Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> \"%s\" to be defined but containing no entries (blank).", getInclusionSetting());
    }
}
