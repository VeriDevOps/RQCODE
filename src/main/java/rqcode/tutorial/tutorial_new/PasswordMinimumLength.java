package rqcode.tutorial.tutorial_new;
import rqcode.concepts.Requirement;
import rqcode.concepts.Checkable;



public class PasswordMinimumLength extends Requirement {
    private String password;

    public PasswordMinimumLength(String password) {
        this.password = password;
    }

    @Override
    public Checkable.CheckStatus check() {
        return (password.length() >= 12) ? Checkable.CheckStatus.PASS : Checkable.CheckStatus.FAIL;
    }

    @Override
    public String toString() {
        Checkable.CheckStatus lengthStatus = (password.length() >= 12) ? Checkable.CheckStatus.PASS : Checkable.CheckStatus.FAIL;
        Checkable.CheckStatus emptyStatus = (!password.isEmpty()) ? Checkable.CheckStatus.PASS : Checkable.CheckStatus.FAIL;

        return "1.1: Passwords must be at least 12 characters long - " + lengthStatus.name() + "\n" +
                "1.2: Passwords should not be empty - " + emptyStatus.name();
    }
}






