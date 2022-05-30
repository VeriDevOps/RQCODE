package main.java.rqcode.patterns.win10;

abstract public class UserRightsAssignRequirement extends LocalPolicyRequirement {
    @Override
    protected String getCategory() {
        return "User Rights Assignment";
    }
}