package rqcode.stigs.win10;

import rqcode.patterns.win10.Win10ExploitProtectionRequirement;

public class V_77091 extends Win10ExploitProtectionRequirement {
    @Override
    public String checkTextCode() {
        return "C-77241r8_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-77189";
    }

    @Override
    public String fixTextCode() {
        return "F-84325r4_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-91885r2_rule";
    }

    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @Override
    public String severity() {
        return "Medium";
    }

    @Override
    public String version() {
        return "WN10-EP-000070";
    }

    @Override
    public String description() {
        return "Exploit protection in Windows 10 provides a means of enabling additional mitigations against potential threats at the system and application level. Without these additional application protections, Windows 10 may be subject to various exploits.";
    }

    @Override
    protected Integer getCommandKey() {
        return 2;
    }

    @Override
    protected String getStatusType() {
        return "DEP";
    }

    @Override
    protected String getStatusName() {
        return "Enable";
    }

    @Override
    protected String getCondition() {
        return "OFF";
    }

    @Override
    protected String getFixTextAdditional() {
        return "Ensure Exploit Protection system-level mitigation, \"Data Execution Prevention (DEP)\", is turned on. The default configuration in Exploit Protection is \"On by default\" which meets this requirement.\n" +
                "\n" +
                "Open \"Windows Defender Security Center\".\n" +
                "\n" +
                "Select \"App & browser control\".\n" +
                "\n" +
                "Select \"Exploit protection settings\".\n" +
                "\n" +
                "Under \"System settings\", configure \"Data Execution Prevention (DEP)\" to \"On by default\" or \"Use default ()\".\n" +
                "\n" +
                "The STIG package includes a DoD EP XML file in the \"Supporting Files\" folder for configuring application mitigations defined in the STIG. This can also be modified to explicitly enforce the system level requirements. Adding the following to the XML file will explicitly turn DEP on (other system level EP requirements can be combined under ):\n";
    }
}
