package rqcode.stigs;

import java.util.Map;

import rqcode.concepts.EnforceableRequirement;

/**
 * This class is a direct mapping of the structure of STIG findings as presented
 * in stigviewer.com. All the member names are self-explanatory.
 */

public abstract class STIG extends EnforceableRequirement {

    /**
     * The STIG definition as it appears in the database.
     */
    private Map<String, String> stigInfo;

    public Map<String, String> getStigInfo() {
        return stigInfo;
    }

    public void setStigInfo(Map<String, String> stigInfo) {
        this.stigInfo = stigInfo;
    }

    /**
     * A crude parsing of the finding (requirement) specification into a document.
     * 
     * @return a string representation of the requirement
     */

    public String toString() {
        return "Overview:\n" +
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
                "- Last check status: " + getLastCheckStatus() + "\n" +
                "- Last enforce status: " + getLastEnforcementStatus() + "\n";
    }

    // public STIG(Map<String, String> stigInfo) {
    //     this.stigInfo = stigInfo;
    // }

    public String id() {
        return stigInfo.get("id");
    }

    public String version() {
        return stigInfo.get("version");
    }

    public String ruleID() {
        return stigInfo.get("ruleID");
    }

    public String iacontrols() {
        return stigInfo.get("iacontrols");
    }

    public String severity() {
        return stigInfo.get("severity");
    }

    public String description() {
        return stigInfo.get("description");
    }

    public String title() {
        return stigInfo.get("title");
    }

    public String date() {
        return stigInfo.get("date");
    }

    public String checkid() {
        return stigInfo.get("checkid");
    }

    public String checktext() {
        return stigInfo.get("checktext");
    }

    public String fixid() {
        return stigInfo.get("fixid");
    }

    public String fixtext() {
        return stigInfo.get("fixtext");
    }
}
