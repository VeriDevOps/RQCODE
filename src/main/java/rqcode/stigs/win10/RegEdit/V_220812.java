package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220812: Credential Guard must be running on Windows 10 domain-joined systems.
 *
 * NOTE: as with V_220811, the STIG warns the registry value alone does not ensure Credential Guard is actually running; a full check additionally requires inspecting Win32_DeviceGuard.SecurityServicesRunning. This class verifies the policy setting only.
 */
public class V_220812 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DeviceGuard",
            "attr", "LsaCfgFlags",
            "result_value",  "1",
            "id", "V_220812"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DeviceGuard",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "LsaCfgFlags",
            "result_value", "1"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220812"),
            Map.entry("title", "Credential Guard must be running on Windows 10 domain-joined systems."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220812r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "Confirm Credential Guard is running on domain-joined systems.\n\nFor those devices that support Credential Guard, this feature must be enabled. Organizations need to take the appropriate action to acquire and implement compatible hardware with Credential Guard enabled.\n\nVirtualization based security, including Credential Guard, currently cannot be implemented in virtual desktop implementations (VDI) due to specific supporting requirements including a TPM, UEFI with Secure Boot, and the capability to run the Hyper-V feature within the virtual desktop.\n\nFor VDIs where the virtual desktop instance is deleted or refreshed upon logoff, this is NA.\n\nRun \"PowerShell\" with elevated privileges (run as administrator).\nEnter the following:\n\"Get-CimInstance -ClassName Win32_DeviceGuard -Namespace root\\Microsoft\\Windows\\DeviceGuard\"\n\nIf \"SecurityServicesRunning\" does not include a value of \"1\" (e.g., \"{1, 2}\"), this is a finding.\n\nAlternately:\n\nRun \"System Information\".\nUnder \"System Summary\", verify the following:\nIf \"Device Guard Security Services Running\" does not list \"Credential Guard\", this is finding.\n\nThe policy settings referenced in the Fix section will configure the following registry value. However, due to hardware requirements, the registry value alone does not ensure proper function.\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\DeviceGuard\\\n\nValue Name: LsaCfgFlags\nValue Type: REG_DWORD\nValue: 0x00000001 (1) (Enabled with UEFI lock)\n\n"),
            Map.entry("checkid", "C-22527r554921_chk"),
            Map.entry("fixtext", "Virtualization based security, including Credential Guard, currently cannot be implemented in virtual desktop implementations (VDI) due to specific supporting requirements including a TPM, UEFI with Secure Boot, and the capability to run the Hyper-V feature within the virtual desktop.\n\nFor VDIs where the virtual desktop instance is deleted or refreshed upon logoff, this is NA.\n\nFor VDIs with persistent desktops, this may be downgraded to a CAT II only where administrators have specific tokens for the VDI. Administrator accounts on virtual desktops must only be used on systems in the VDI; they may not have administrative privileges on any other systems such as servers and physical workstations.\n\nConfigure the policy value for Computer Configuration >> Administrative Templates >> System >> Device Guard >> \"Turn On Virtualization Based Security\" to \"Enabled\" with \"Enabled with UEFI lock\" selected for \"Credential Guard Configuration:\".\n\nv1507 LTSB does not include selection options; select \"Enable Credential Guard\".\n\nA Microsoft TechNet article on Credential Guard, including system requirement details, can be found at the following link:\n\nhttps://docs.microsoft.com/en-us/windows/access-protection/credential-guard/credential-guard"),
            Map.entry("fixid", "F-22516r554922_fix"),
            Map.entry("description", "Credential Guard uses virtualization based security to protect information that could be used in credential theft attacks if compromised. This authentication information, which was stored in the Local Security Authority (LSA) in previous versions of Windows, is isolated from the rest of operating system and can only be accessed by privileged system software."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000075")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220812() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220812();

        //running command line interface for V_220812
        cli(stig, args);
    }

}
