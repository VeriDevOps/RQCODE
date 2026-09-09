package rqcode.stigs.win10.RegEdit;

import java.util.List;
import java.util.Map;

/**
 * V_220836: The Windows Defender SmartScreen for Explorer must be enabled.
 *
 * This finding requires 2 registry values to hold jointly, so it extends
 * {@link MultiPathRegEditStig} rather than {@link RegEditStig}.
 */
public class V_220836 extends MultiPathRegEditStig {

    private final static List<Map<String, String>> ENTRIES = List.of(
            Map.of("path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\System", "attr", "EnableSmartScreen", "result_value", "1"),
            Map.of("path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\System", "attr", "ShellSmartScreenLevel", "result_value", "Block")
            );

    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220836"),
            Map.entry("title", "The Windows Defender SmartScreen for Explorer must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220836r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This is applicable to unclassified systems, for other systems this is NA.\n\nIf the following registry values do not exist or are not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\System\\\n\nValue Name: EnableSmartScreen\n\nValue Type: REG_DWORD\nValue: 0x00000001 (1)\n\nAnd\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\System\\\n\nValue Name: ShellSmartScreenLevel\n\nValue Type: REG_SZ\nValue: Block\n\nv1607 LTSB:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\System\\\n\nValue Name: EnableSmartScreen\n\nValue Type: REG_DWORD\nValue: 0x00000001 (1)\n\nv1507 LTSB:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\System\\\n\nValue Name: EnableSmartScreen\n\nValue Type: REG_DWORD\nValue: 0x00000002 (2)"),
            Map.entry("checkid", "C-22551r554993_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> File Explorer >> \"Configure Windows Defender SmartScreen\" to \"Enabled\" with \"Warn and prevent bypass\" selected. \n\nWindows 10 includes duplicate policies for this setting. It can also be configured under Computer Configuration >> Administrative Templates >> Windows Components >> Windows Defender SmartScreen >> Explorer.\n\nv1607 LTSB:\nConfigure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> File Explorer >> \"Configure Windows SmartScreen\" to \"Enabled\". (Selection options are not available.)\n\nv1507 LTSB:\nConfigure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> File Explorer >> \"Configure Windows SmartScreen\" to \"Enabled\" with \"Require approval from an administrator before running downloaded unknown software\" selected."),
            Map.entry("fixid", "F-22540r554994_fix"),
            Map.entry("description", "Windows Defender SmartScreen helps protect systems from programs downloaded from the internet that may be malicious. Enabling Windows Defender SmartScreen will warn or prevent users from running potentially malicious programs."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000210")
            );

    /**
     * Setting up STIG information and the {path, attr, result_value} triples
     * this finding must satisfy jointly.
     */
    public V_220836() {
        setStigInfo(INFO);
        setEntries(ENTRIES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        MultiPathRegEditStig stig = new V_220836();

        //running command line interface for V_220836
        cli(stig, args);
    }

}
