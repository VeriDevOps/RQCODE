package rqcode.stigs.win10.RegEdit;

import java.util.List;
import java.util.Map;

/**
 * V_250319: Hardened UNC Paths must be defined to require mutual authentication and integrity for at least the \\\\*\\SYSVOL and \\\\*\\NETLOGON shares.
 *
 * This finding requires 2 registry values to hold jointly, so it extends
 * {@link MultiPathRegEditStig} rather than {@link RegEditStig}.
 */
public class V_250319 extends MultiPathRegEditStig {

    private final static List<Map<String, String>> ENTRIES = List.of(
            Map.of("path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\NetworkProvider\\HardenedPaths", "attr", "\\\\*\\NETLOGON", "result_value", "RequireMutualAuthentication=1, RequireIntegrity=1"),
            Map.of("path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\NetworkProvider\\HardenedPaths", "attr", "\\\\*\\SYSVOL", "result_value", "RequireMutualAuthentication=1, RequireIntegrity=1")
            );

    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_250319"),
            Map.entry("title", "Hardened UNC Paths must be defined to require mutual authentication and integrity for at least the \\\\*\\SYSVOL and \\\\*\\NETLOGON shares."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_250319r793294_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "This requirement is applicable to domain-joined systems, for standalone systems this is NA.\n\nIf the following registry values do not exist or are not configured as specified, this is a finding.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\NetworkProvider\\HardenedPaths\\\n\nValue Name: \\\\*\\NETLOGON\nValue Type: REG_SZ\nValue: RequireMutualAuthentication=1, RequireIntegrity=1\n\nValue Name: \\\\*\\SYSVOL\nValue Type: REG_SZ\nValue: RequireMutualAuthentication=1, RequireIntegrity=1\n\nAdditional entries would not be a finding."),
            Map.entry("checkid", "C-53754r793290_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Network >> Network Provider >> \"Hardened UNC Paths\" to \"Enabled\" with at least the following configured in \"Hardened UNC Paths:\" (click the \"Show\" button to display).\n\nValue Name: \\\\*\\SYSVOL\nValue: RequireMutualAuthentication=1, RequireIntegrity=1\n\nValue Name: \\\\*\\NETLOGON\nValue: RequireMutualAuthentication=1, RequireIntegrity=1"),
            Map.entry("fixid", "F-53708r793291_fix"),
            Map.entry("description", "Additional security requirements are applied to Universal Naming Convention (UNC) paths specified in Hardened UNC paths before allowing access them. This aids in preventing tampering with or spoofing of connections to these paths."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000050")
            );

    /**
     * Setting up STIG information and the {path, attr, result_value} triples
     * this finding must satisfy jointly.
     */
    public V_250319() {
        setStigInfo(INFO);
        setEntries(ENTRIES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        MultiPathRegEditStig stig = new V_250319();

        //running command line interface for V_250319
        cli(stig, args);
    }

}
