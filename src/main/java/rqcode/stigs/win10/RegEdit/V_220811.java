package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220811: Virtualization Based Security must be enabled on Windows 10 with the platform security level configured to Secure Boot or Secure Boot with DMA Protection.
 *
 * NOTE: the STIG's own check text states that, due to hardware dependencies, this registry value alone does not guarantee Virtualization Based Security is actually running -- a full check additionally requires inspecting Win32_DeviceGuard.VirtualizationBasedSecurityStatus. This class verifies the policy setting only (necessary, not sufficient).
 */
public class V_220811 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DeviceGuard",
            "attr", "EnableVirtualizationBasedSecurity",
            "result_value",  "1",
            "id", "V_220811"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DeviceGuard",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "EnableVirtualizationBasedSecurity",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220811"),
            Map.entry("title", "Virtualization Based Security must be enabled on Windows 10 with the platform security level configured to Secure Boot or Secure Boot with DMA Protection."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220811r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "Confirm Virtualization Based Security is enabled and running with Secure Boot or Secure Boot and DMA Protection.\n\nFor those devices that support virtualization based security (VBS) features, including Credential Guard or protection of code integrity, this must be enabled. If the system meets the hardware and firmware dependencies for enabling VBS but it is not enabled, this is a CAT III finding.\n\nVirtualization based security, including Credential Guard, currently cannot be implemented in virtual desktop implementations (VDI) due to specific supporting requirements including a TPM, UEFI with Secure Boot, and the capability to run the Hyper-V feature within the virtual desktop.\n\nFor VDIs where the virtual desktop instance is deleted or refreshed upon logoff, this is NA.\n\nRun \"PowerShell\" with elevated privileges (run as administrator).\n\nEnter the following:\n\n\"Get-CimInstance -ClassName Win32_DeviceGuard -Namespace root\\Microsoft\\Windows\\DeviceGuard\"\n\nIf \"RequiredSecurityProperties\" does not include a value of \"2\" indicating \"Secure Boot\" (e.g., \"{1, 2}\"), this is a finding.\n\nIf \"Secure Boot and DMA Protection\" is configured, \"3\" will also be displayed in the results (e.g., \"{1, 2, 3}\").\n\nIf \"VirtualizationBasedSecurityStatus\" is not a value of \"2\" indicating \"Running\", this is a finding.\n\nAlternately:\n\nRun \"System Information\".\n\nUnder \"System Summary\", verify the following:\n\nIf \"Device Guard Virtualization based security\" does not display \"Running\", this is finding.\n\nIf \"Device Guard Required Security Properties\" does not display \"Base Virtualization Support, Secure Boot\", this is finding.\n\nIf \"Secure Boot and DMA Protection\" is configured, \"DMA Protection\" will also be displayed (e.g., \"Base Virtualization Support, Secure Boot, DMA Protection\").\n\nThe policy settings referenced in the Fix section will configure the following registry values. However due to hardware requirements, the registry values alone do not ensure proper function.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\DeviceGuard\\\n\nValue Name: EnableVirtualizationBasedSecurity\nValue Type: REG_DWORD\nValue: 1\n\nValue Name: RequirePlatformSecurityFeatures\nValue Type: REG_DWORD\nValue: 1 (Secure Boot only) or 3 (Secure Boot and DMA Protection)\n\nA Microsoft article on Credential Guard system requirement can be found at the following link:\n\nhttps://technet.microsoft.com/en-us/itpro/windows/keep-secure/credential-guard-requirements\n\nNOTE:  The severity level for the requirement will be upgraded to CAT II starting January 2020."),
            Map.entry("checkid", "C-22526r554918_chk"),
            Map.entry("fixtext", "Virtualization based security, including Credential Guard, currently cannot be implemented in virtual desktop implementations (VDI) due to specific supporting requirements including a TPM, UEFI with Secure Boot, and the capability to run the Hyper-V feature within the virtual desktop.\n\nFor VDIs where the virtual desktop instance is deleted or refreshed upon logoff, this is NA.\n\nConfigure the policy value for Computer Configuration >> Administrative Templates >> System >> Device Guard >> \"Turn On Virtualization Based Security\" to \"Enabled\" with \"Secure Boot\" or \"Secure Boot and DMA Protection\" selected for \"Select Platform Security Level:\".\n\nA Microsoft article on Credential Guard system requirement can be found at the following link.\nhttps://technet.microsoft.com/en-us/itpro/windows/keep-secure/credential-guard-requirements"),
            Map.entry("fixid", "F-22515r554919_fix"),
            Map.entry("description", "Virtualization Based Security (VBS) provides the platform for the additional security features, Credential Guard and Virtualization based protection of code integrity.  Secure Boot is the minimum security level with DMA protection providing additional memory protection.  DMA Protection requires a CPU that supports input/output memory management unit (IOMMU)."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000070")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220811() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220811();

        //running command line interface for V_220811
        cli(stig, args);
    }

}
