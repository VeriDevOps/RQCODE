package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220955: Audit policy using subcategories must be enabled.. 
 */
public class V_220955 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Attachments",
            "attr", "SaveZoneInformation",
            "result_value",  "2",
            "id", "V_220955"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\Attachments",
            "path_short", "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies",
            "attr", "SaveZoneInformation",
            "result_value", "2"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220955"),
            Map.entry("title", "Audit policy using subcategories must be enabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "medium"),
            Map.entry("checktext", "Confirm Virtualization Based Security is enabled and running with Secure Boot or Secure Boot and DMA Protection.\\n\\nFor those devices that support virtualization based security (VBS) features, including Credential Guard or protection of code integrity, this must be enabled. If the system meets the hardware and firmware dependencies for enabling VBS but it is not enabled, this is a CAT III finding.\\n\\nVirtualization based security, including Credential Guard, currently cannot be implemented in virtual desktop implementations (VDI) due to specific supporting requirements including a TPM, UEFI with Secure Boot, and the capability to run the Hyper-V feature within the virtual desktop.\\n\\nFor VDIs where the virtual desktop instance is deleted or refreshed upon logoff, this is NA.\\n\\nRun \\PowerShell\\ with elevated privileges (run as administrator).\\n\\nEnter the following:\\n\\n\\Get-CimInstance -ClassName Win32_DeviceGuard -Namespace root\\Microsoft\\Windows\\DeviceGuard\\\\n\\nIf \\RequiredSecurityProperties\\ does not include a value of \\2\\ indicating \\Secure Boot\\ (e.g., \\{1, 2}\\), this is a finding.\\n\\nIf \\Secure Boot and DMA Protection\\ is configured, \\3\\ will also be displayed in the results (e.g., \\{1, 2, 3}\\).\\n\\nIf \\VirtualizationBasedSecurityStatus\\ is not a value of \\2\\ indicating \\Running\\ this is a finding.\\n\\nAlternately:\\n\\nRun \\System Information\\.\\n\\nUnder \\System Summary\\ verify the following:\\n\\nIf \\Device Guard Virtualization based security\\ does not display \\Running\\ this is finding.\\n\\nIf \\Device Guard Required Security Properties\\ does not display \\Base Virtualization Support, Secure Boot\\ this is finding.\\n\\nIf \\Secure Boot and DMA Protection\\ is configured, \\DMA Protection\\ will also be displayed (e.g., \\Base Virtualization Support, Secure Boot, DMA Protection\\).\\n\\nThe policy settings referenced in the Fix section will configure the following registry values. However due to hardware requirements, the registry values alone do not ensure proper function.\\n\\nRegistry Hive: HKEY_LOCAL_MACHINE\\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\DeviceGuard\\\\n\\nValue Name: EnableVirtualizationBasedSecurity\\nValue Type: REG_DWORD\\nValue: 1\\n\\nValue Name: RequirePlatformSecurityFeatures\\nValue Type: REG_DWORD\\nValue: 1 (Secure Boot only) or 3 (Secure Boot and DMA Protection)\\n\\nA Microsoft article on Credential Guard system requirement can be found at the following link:\\n\\nhttps://technet.microsoft.com/en-us/itpro/windows/keep-secure/credential-guard-requirements\\n\\nNOTE: The severity level for the requirement will be upgraded to CAT II starting January 2020."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "The default behavior is for Windows to mark file attachments with their zone information.\\n\\nIf this needs to be corrected, configure the policy value for User Configuration >> Administrative Templates >> Windows Components >> Attachment Manager >> \\Do not preserve zone information in file attachments\\ to \\Not Configured\\ or \\Disabled\\."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Preserving zone of origin (internet, intranet, local, restricted) information on file attachments allows Windows to determine risk."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-UC-000020")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220955() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220955();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
