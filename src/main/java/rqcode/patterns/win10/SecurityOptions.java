
package rqcode.patterns.win10;

abstract public class SecurityOptions extends LocalPolicyRequirement {
    @Override
    protected String getCategory() {
        return "Security Options";
    }

    @Override
    public String checkText() {
        return "If the following registry value does not exist or is not configured as specified, this is a finding:\n" +
                "\n" +
                "Registry Hive: HKEY_LOCAL_MACHINE\n" +
                String.format("Registry Path: \\SYSTEM\\CurrentControlSet\\Services\\%s\\Parameters\\\n", getPathFolder()) +
                "\n" +
                String.format("Value Name: %s\n", getValueName()) +
                "\n" +
                "Value Type: REG_DWORD\n" +
                "Value: 1";
    }

    @Override
    public String fixText() {
        return String.format("Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> Security Options" +
                " >> \"%s\" to \"Enabled\".", getInclusionSetting());
    }

    @Override
    protected String getSubcategory() {
        return null;
    }

    public abstract String getValueName();
    public abstract String getPathFolder();
}
