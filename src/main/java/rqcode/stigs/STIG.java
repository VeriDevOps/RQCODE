package rqcode.stigs;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import rqcode.concepts.Enforceable;
import rqcode.concepts.Requirement;

/**
 * This class is a direct mapping of the structure of STIG findings as presented in stigviewer.com. All the member names are self-explanatory.
 */

public abstract class STIG extends Requirement implements Enforceable{
    
    public abstract String findingID();

    
    public abstract String version();

    
    public abstract String ruleID();

    
    public abstract String iAControls();

    
    public abstract String severity();

    
    public abstract String description();

    
    public abstract String sTIG();

    
    public abstract String date();

    
    public abstract String checkTextCode();

    
    public abstract String checkText();

    
    public abstract String fixTextCode();

    
    public abstract String fixText();

    /**
     * A crude parsing of the finding (requirement) specification into a document.
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
