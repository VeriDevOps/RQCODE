package rqcode.concepts;

/**
 * This class is a direct mapping of the structure of STIG findings as presented in stigviewer.com. All the member
 * names are self-explanatory.
 */
public abstract class Requirement {
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

    /**
     * A crude parsing of the finding (requirement) specification into a document. Hopefully in the future we would
     * parse it as HTML.
     * @return a string representation of the requirement
     */
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