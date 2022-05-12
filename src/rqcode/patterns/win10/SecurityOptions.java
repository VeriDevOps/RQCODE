
package rqcode.patterns.win10;

abstract public class SecurityOptions extends LocalPolicyRequirement {
    @Override
    protected String getCategory() {
        return "User Rights Assignment";
    }
}
