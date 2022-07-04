package rqcode.stigs.win10;

import rqcode.patterns.win10.Win10ExploitProtectionRequirement;

public class V_77095 extends Win10ExploitProtectionRequirement {
    @Override
    public String checkTextCode() {
        return "C-79581r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-77095";
    }

    @Override
    public String fixTextCode() {
        return "F-86719r3_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-91791r4_rule";
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
        return "WN10-EP-000030";
    }

    @Override
    public String description() {
        return "Exploit protection in Windows 10 enables mitigations against potential threats at the system and application level. Several mitigations, including \"Randomize memory allocations (Bottom-Up ASLR)\", are enabled by default at the system level. Bottom-Up ASLR (address space layout randomization) randomizes locations for virtual memory allocations, including those for system structures. If this is turned off, Windows 10 may be subject to various exploits.";
    }

    @Override
    protected Integer getCommandKey() {
        return 1;
    }

    @Override
    protected String getStatusType() {
        return "ASLR";
    }

    @Override
    protected String getStatusName() {
        return "BottomUp";
    }

    @Override
    protected String getCondition() {
        return "OFF";
    }

    @Override
    protected String getFixTextAdditional() {
        return "Ensure Exploit Protection system-level mitigation, \"Randomize memory allocations (Bottom-Up ASLR)\" is turned on. The default configuration in Exploit Protection is \"On by default\" which meets this requirement.\n" +
                "\n" +
                "Open \"Windows Defender Security Center\".\n" +
                "\n" +
                "Select \"App & browser control\".\n" +
                "\n" +
                "Select \"Exploit protection settings\".\n" +
                "\n" +
                "Under \"System settings\", configure \"Randomize memory allocations (Bottom-Up ASLR)\" to \"On by default\" or \"Use default ()\".\n" +
                "\n" +
                "The STIG package includes a DoD EP XML file in the \"Supporting Files\" folder for configuring application mitigations defined in the STIG. This can also be modified to explicitly enforce the system level requirements. Adding the following to the XML file will explicitly turn Bottom-Up ASLR on (other system level EP requirements can be combined under ):";
    }
}
