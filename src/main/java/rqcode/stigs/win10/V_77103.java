package rqcode.stigs.win10;

import rqcode.stigs.win10.patterns.Win10ExploitProtectionRequirement;

/**
 * Exploit protection in Windows 10 enables mitigations against potential threats at the system and application level.
 * Several mitigations, including "Validate heap integrity", are enabled by default at the system level.
 * "Validate heap integrity" terminates a process when heap corruption is detected.
 * If this is turned off, Windows 10 may be subject to various exploits.
 *
 * https://www.stigviewer.com/stig/windows_10/2019-01-04/finding/V-77103
 */

public class V_77103 extends Win10ExploitProtectionRequirement {
    @Override
    public String checkid() {
        return "C-79587r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String id() {
        return "V-77103";
    }

    @Override
    public String fixid() {
        return "F-86725r2_fix";
    }

    @Override
    public String iacontrols() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-91799r3_rule";
    }

    @Override
    public String title(){
        return "Windows 10 Security Technical Implementation Guide";
    }

    @Override
    public String severity() {
        return "Medium";
    }

    @Override
    public String version() {
        return "WN10-EP-000060";
    }

    @Override
    public String description() {
        return "Exploit protection in Windows 10 provides a means of enabling additional mitigations against potential threats at the system and application level. Without these additional application protections, Windows 10 may be subject to various exploits.";
    }

    @Override
    protected Integer getCommandKey() {
        return 1;
    }

    @Override
    protected String getStatusType() {
        return "HEAP";
    }

    @Override
    protected String getStatusName() {
        return "TerminateOnError";
    }

    @Override
    protected String getCondition() {
        return "NOTSET";
    }

    @Override
    protected String getFixTextAdditional() {
        return "Ensure Exploit Protection system-level mitigation, \"Validate heap integrity\" is turned on. The default configuration in Exploit Protection is \"On by default\" which meets this requirement.\n" +
                "\n" +
                "Open \"Windows Defender Security Center\".\n" +
                "\n" +
                "Select \"App & browser control\".\n" +
                "\n" +
                "Select \"Exploit protection settings\".\n" +
                "\n" +
                "Under \"System settings\", configure \"Validate heap integrity\" to \"On by default\" or \"Use default ()\".\n" +
                "\n" +
                "The STIG package includes a DoD EP XML file in the \"Supporting Files\" folder for configuring application mitigations defined in the STIG. This can also be modified to explicitly enforce the system level requirements. Adding the following to the XML file will explicitly turn Validate heap integrity on (other system level EP requirements can be combined under ):";
    }
}
