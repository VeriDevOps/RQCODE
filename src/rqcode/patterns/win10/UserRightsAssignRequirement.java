package patterns;

abstract public class UserRightsAssignRequirement extends LocalPolicyRequirement {
    @Override
    protected String getCategory() {
        return "User Rights Assignment";
    }
}