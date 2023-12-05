package rqcode.stigs;

import rqcode.concepts.EnforceableRequirement;

/**
 * This class is a direct mapping of the structure of STIG findings as presented in stigviewer.com. All the member names are self-explanatory.
 */

public abstract class STIG extends EnforceableRequirement{
    
    public abstract String id();

    
    public abstract String version();

    
    public abstract String ruleID();

    
    public abstract String iacontrols();

    
    public abstract String severity();

    
    public abstract String description();

    
    public abstract String title();

    
    public abstract String date();

    
    public abstract String checkid();

    
    public abstract String checktext();

    
    public abstract String fixid();

    
    public abstract String fixtext();

    /**
     * A crude parsing of the finding (requirement) specification into a document.
     * @return a string representation of the requirement
     */
    
    public String toString() {
        return
        "Overview:\n" + 
        "=========\n" +
        "- Finding ID: " + id() + "\n" +
        "- Version: " + version() + "\n" +
        "- Rule ID: " + ruleID() + "\n" +
        "- IA Controls: " + iacontrols() + "\n" +
        "- Severity: " + severity() + "\n" +
        "\n" +
        "- STIG: " + title() + "\n" +
        "- Description:\n" +
        description() + "\n" +
        "- Date: " + date() + "\n" +
        "\n" +
        "Details:\n" +
        "========\n" +
        "- Check Text (" + checkid() + ")" + "\n" +
        checktext() + "\n" + 
        "- Fix Text (" + fixid() + ")" + "\n" +
        fixtext() + "\n\n" +
        "Status:\n" +
        "========\n" +
        "- Last check status: " + getLastCheckStatus()+ "\n" +
        "- Last enforce status: " + getLastEnforcementStatus()+ "\n";
    }

}
