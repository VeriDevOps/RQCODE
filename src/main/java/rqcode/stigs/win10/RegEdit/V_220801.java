package rqcode.stigs.win10.RegEdit;

import java.util.List;
import java.util.Map;

/**
 * V_220801: Run as different user must be removed from context menus.
 *
 * This finding requires 4 registry values to hold jointly, so it extends
 * {@link MultiPathRegEditStig} rather than {@link RegEditStig}.
 */
public class V_220801 extends MultiPathRegEditStig {

    private final static List<Map<String, String>> ENTRIES = List.of(
            Map.of("path", "HKLM:\\SOFTWARE\\Classes\\batfile\\shell\\runasuser", "attr", "SuppressionPolicy", "result_value", "4096"),
            Map.of("path", "HKLM:\\SOFTWARE\\Classes\\cmdfile\\shell\\runasuser", "attr", "SuppressionPolicy", "result_value", "4096"),
            Map.of("path", "HKLM:\\SOFTWARE\\Classes\\exefile\\shell\\runasuser", "attr", "SuppressionPolicy", "result_value", "4096"),
            Map.of("path", "HKLM:\\SOFTWARE\\Classes\\mscfile\\shell\\runasuser", "attr", "SuppressionPolicy", "result_value", "4096")
            );

    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220801"),
            Map.entry("title", "Run as different user must be removed from context menus."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220801r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "If the following registry values do not exist or are not configured as specified, this is a finding.\nThe policy configures the same Value Name, Type and Value under four different registry paths.\n\nRegistry Hive:  HKEY_LOCAL_MACHINE\nRegistry Paths:  \n\\SOFTWARE\\Classes\\batfile\\shell\\runasuser\\\n\\SOFTWARE\\Classes\\cmdfile\\shell\\runasuser\\\n\\SOFTWARE\\Classes\\exefile\\shell\\runasuser\\\n\\SOFTWARE\\Classes\\mscfile\\shell\\runasuser\\\n\nValue Name:  SuppressionPolicy\n\nType:  REG_DWORD\nValue:  0x00001000 (4096)"),
            Map.entry("checkid", "C-22516r554888_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MS Security Guide >> \"Remove \"Run as Different User\" from context menus\" to \"Enabled\".\n\nThis policy setting requires the installation of the SecGuide custom templates included with the STIG package.  \"SecGuide.admx\" and \"SecGuide.adml\" must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22505r554889_fix"),
            Map.entry("description", "The \"Run as different user\" selection from context menus allows the use of credentials other than the currently logged on user.  Using privileged credentials in a standard user session can expose those credentials to theft.  Removing this option from context menus helps prevent this from occurring."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000039")
            );

    /**
     * Setting up STIG information and the {path, attr, result_value} triples
     * this finding must satisfy jointly.
     */
    public V_220801() {
        setStigInfo(INFO);
        setEntries(ENTRIES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        MultiPathRegEditStig stig = new V_220801();

        //running command line interface for V_220801
        cli(stig, args);
    }

}
