package stig;

public abstract class STIG {
    abstract public String findingID();

    abstract public String version();

    abstract public String ruleID();

    abstract public String iAControls();

    abstract public String severity();

    abstract public String description();

    abstract public String sTIG();

    abstract public String date();

    abstract public String checkTextCode();

    abstract public String checkText();

    abstract public String fixTextCode();

    abstract public String fixText();

    public String toString() {
        return
        "Overview:\n" + 
        "=========\n" +
        "- Finding ID: " + findingID() + "\n" +
        "- Version: " + version() + "\n" +
        "- Rule ID: " + ruleID() + "\n" +
        "- IA Controls: " + iAControls() + "\n" +
        "- Severity: " + severity() + "\n" +
        "- Description:\n" +
        description() + "\n" +
        "\n" +
        "- STIG: " + sTIG() + "\n" +
        "- Date: " + date() + "\n" +
        "\n" +
        "Details:\n" +
        "========\n" +
        "- Check Text (" + checkTextCode() + ")" + "\n" +
        checkText() + "\n" + 
        "- Fix Text (" + fixTextCode() + ")" + "\n" +
        fixText() + "\n";
    }
}