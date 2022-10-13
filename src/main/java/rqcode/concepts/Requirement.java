package rqcode.concepts;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * This class is a direct mapping of the structure of STIG findings as presented in stigviewer.com. All the member names are self-explanatory.
 */
@objid ("301d7b51-4cb1-48dc-8a0f-5601312b461c")
public abstract class Requirement {
    @objid ("971cdff3-a556-43b2-a8d4-97bdd6fe07cf")
    public abstract String findingID();

    @objid ("b7a26255-97e1-4e22-bd7f-dca1d74c30c0")
    public abstract String version();

    @objid ("aac6674c-54f9-4168-a672-445c3108dbd2")
    public abstract String ruleID();

    @objid ("af3b0533-b1fd-44d5-9bca-7598a29e3b22")
    public abstract String iAControls();

    @objid ("45570ab9-5674-4c2f-8edb-8bfbab5e008d")
    public abstract String severity();

    @objid ("f00844d1-c567-45c5-8381-316a1ae8d38d")
    public abstract String description();

    @objid ("eb0c7387-c246-4feb-bded-ab9c17210361")
    public abstract String sTIG();

    @objid ("53307f71-88ec-4df1-8919-0615a5c1ddf7")
    public abstract String date();

    @objid ("978c9dc3-c9d6-4f29-be76-cd19406cf7ec")
    public abstract String checkTextCode();

    @objid ("c347afe8-ca2d-4d9a-964f-d20d54e5910a")
    public abstract String checkText();

    @objid ("3225a2dd-a460-464c-b245-43dafe6c43cf")
    public abstract String fixTextCode();

    @objid ("0fc58ac3-22e8-4f03-86a1-03a865417b05")
    public abstract String fixText();

    /**
     * A crude parsing of the finding (requirement) specification into a document.
     * @return a string representation of the requirement
     */
    @objid ("f54ccddd-2dce-458f-8936-7f935c38ed83")
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
