package rqcode.stigs.win10.RegEdit;

import java.util.Map;

import rqcode.stigs.win10.WinScriptHelper;

/**
 * V_220835: Windows Update must not obtain updates from other PCs on the Internet.
 *
 * NOTE: the STIG treats several DODownloadMode values as compliant (0, 1, 2, 99, 100); only 3 (Internet) is a finding. This class checks for 0 (no peering).
 */
public class V_220835 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DeliveryOptimization",
            "attr", "DODownloadMode",
            "result_value",  "0",
            "id", "V_220835"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\DeliveryOptimization",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
            "attr", "DODownloadMode",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220835"),
            Map.entry("title", "Windows Update must not obtain updates from other PCs on the Internet."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220835r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "If the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\DeliveryOptimization\\\n\nValue Name: DODownloadMode\n\nValue Type: REG_DWORD\nValue: 0x00000000 (0) - No peering (HTTP Only)\n0x00000001 (1) - Peers on same NAT only (LAN)\n0x00000002 (2) - Local Network / Private group peering (Group)\n0x00000063 (99) - Simple download mode, no peering (Simple)\n0x00000064 (100) - Bypass mode, Delivery Optimization not used (Bypass)\n\nA value of 0x00000003 (3), Internet, is a finding.\n\nv1507 LTSB:\nDomain joined systems:\nVerify the registry value above.\nIf the value is not 0x00000000 (0) or 0x00000001 (1), this is a finding.\n\nStandalone systems (configured in Settings):\nIf the following registry value does not exist or is not configured as specified, this is a finding:\n\nRegistry Hive: HKEY_LOCAL_MACHINE\nRegistry Path: \\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\DeliveryOptimization\\Config\\\n\nValue Name: DODownloadMode\n\nValue Type: REG_DWORD\nValue: 0x00000000 (0) - Off\n0x00000001 (1) - LAN"),
            Map.entry("checkid", "C-22550r554990_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Delivery Optimization >> \"Download Mode\" to \"Enabled\" with any option except \"Internet\" selected.\n\nAcceptable selections include:\nBypass (100)\nGroup (2)\nHTTP only (0)\nLAN (1)\nSimple (99)\n\nv1507 (LTSB) does not include this group policy setting locally. For domain joined systems, configure through domain group policy as \"HTTP only (0)\" or \"Lan (1)\". Standalone systems configure using Settings >> Update & Security >> Windows Update >> Advanced Options >> \"Choose how updates are delivered\" with either \"Off\" or \"PCs on my local network\" selected."),
            Map.entry("fixid", "F-22539r554991_fix"),
            Map.entry("description", "Windows 10 allows Windows Update to obtain updates from additional sources instead of Microsoft. In addition to Microsoft, updates can be obtained from and sent to PCs on the local network as well as on the Internet. This is part of the Windows Update trusted process, however to minimize outside exposure, obtaining updates from or sending to systems on the Internet must be prevented."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000206")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220835() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220835();

        //running command line interface for V_220835
        cli(stig, args);
    }

}
