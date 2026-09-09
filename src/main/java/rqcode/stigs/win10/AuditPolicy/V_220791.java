package rqcode.stigs.win10.AuditPolicy;

import rqcode.stigs.STIG;
import rqcode.stigs.win10.WinScriptHelper;

import java.util.Map;

/**
 * V_220791: Windows 10 must be configured to audit MPSSVC Rule-Level Policy Change Failures.
 *
 * NOTE: "guid" carries the auditpol subcategory *display name* rather than
 * its GUID -- auditpol.exe accepts either for /subcategory:, and the name is
 * quoted verbatim from the STIG's own fix text, which avoids depending on a
 * hand-transcribed GUID table.
 */
public class V_220791 extends AuditPolStig {
        /**
         * Initiating parameters for the check script
        */
        private final static Map<String, String> CHECK_VALUES = Map.of(
                        "id", "V_220791",
                        "guid", "MPSSVC Rule-Level Policy Change",
                        "subcat_es", "errores",
                        "subcat_eng", "failure"
                        );

        /**
         * Initiating parameters for the enforce script
         */
        private final static Map<String, String> ENFORCE_VALUES = Map.of(
                        "id", "V_220791",
                        "guid", "MPSSVC Rule-Level Policy Change",
                        "parameter", "Failure",
                        "value", "enable"
                        );
        /**
         * Initiating information defining the security requirements from the STIG
         * database
         */
        private final static Map<String, String> INFO = Map.ofEntries(
                        Map.entry("id", "V_220791"),
                        Map.entry("title", "Windows 10 must be configured to audit MPSSVC Rule-Level Policy Change Failures."),
                        Map.entry("date", "2021-08-18"),
                        Map.entry("ruleID", "SV_220791r569187_rule"),
                        Map.entry("severity", "medium"),
                        Map.entry("checktext", "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective.\n\nUse the AuditPol tool to review the current Audit Policy configuration:\nOpen a Command Prompt with elevated privileges (\"Run as Administrator\").\nEnter \"AuditPol /get /category:*\".\n\nCompare the AuditPol settings with the following. If the system does not audit the following, this is a finding:\n\nPolicy Change  >> MPSSVC Rule-Level Policy Change - Failure\n"),
                        Map.entry("checkid", "C-22506r554858_chk"),
                        Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Policy Change >> \u201cAudit MPSSVC Rule-Level Policy Change\" with \"Failure\" selected."),
                        Map.entry("fixid", "F-22495r554859_fix"),
                        Map.entry("description", "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\n\nAudit MPSSVC Rule-Level Policy Change determines whether the operating system generates audit events when changes are made to policy rules for the Microsoft Protection Service (MPSSVC.exe). "),
                        Map.entry("iacontrols", "null"),
                        Map.entry("version", "WN10-AU-000580")
                        );

        /**
         * Setting up STIG information and initializing the windows script helper with
         * the check and enforce parameters
         */
        public V_220791() {
                setStigInfo(INFO);
                WinScriptHelper helper = this.getHelper();
                helper.setCheckValues(CHECK_VALUES);
                helper.setEnforceValues(ENFORCE_VALUES);
        }

        /**
         * Simple test for the STIG check
         */
        public static void main(String[] args) {
                STIG stig = new V_220791();
                //running command line interface for V_220791
                cli(stig, args);
        }

}