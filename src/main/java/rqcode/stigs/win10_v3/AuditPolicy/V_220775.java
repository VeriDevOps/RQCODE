package rqcode.stigs.win10_v3.AuditPolicy;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

import java.util.Map;

/**
 * V_220775: The system must be configured to audit System - Security State Change successes.
 */
public class V_220775 extends AuditPolStig {
        /**
         * Initiating parameters for the check script
        */
        private final static Map<String, String> CHECK_VALUES = Map.of(
                        "id", "V_220775",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "subcat_es", "acierto",
                        "subcat_eng", "success"
                        );

        /**
         * Initiating parameters for the enforce script
         */
        private final static Map<String, String> ENFORCE_VALUES = Map.of(
                        "id", "V_220775",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "parameter", "Success",
                        "value", "enable"
                        );
        /**
         * Initiating information defining the security requirements from the STIG
         * database
         */
        private final static Map<String, String> INFO = Map.ofEntries(
                        Map.entry("id", "V_220775"),
                        Map.entry("title", "The system must be configured to audit System - Security State Change successes."),
                        Map.entry("date", "2021-08-18"),
                        Map.entry("ruleID", "SV_220775r569187_rule"),
                        Map.entry("severity", "medium"),
                        Map.entry("checktext", "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective.\n\nUse the AuditPol tool to review the current Audit Policy configuration:\nOpen a Command Prompt with elevated privileges (\"Run as Administrator\").\nEnter \"AuditPol /get /category:*\".\n\nCompare the AuditPol settings with the following.  If the system does not audit the following, this is a finding:\n\nSystem >> Security State Change - Success"),
                        Map.entry("checkid", "C-22481r554783_chk"),
                        Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> System >> \"Audit Security State Change\" with \"Success\" selected."),
                        Map.entry("fixid", "F-22470r554784_fix"),
                        Map.entry("description","Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\n\nAudit Other System Events records information related to cryptographic key operations and the Windows Firewall service."),
                        Map.entry("iacontrols", "$iacontrols"),
                        Map.entry("version", "WN10-AU-000140")
                        );
                    
        /**
         * Setting up STIG information and initializing the windows script helper with
         * the check and enforce parameters
         */
        public V_220775() {
                setStigInfo(INFO);
                WinScriptHelper helper = this.getHelper();
                helper.setCheckValues(CHECK_VALUES);
                helper.setEnforceValues(ENFORCE_VALUES);
        }

        /**
         * Simple test for the STIG check
         */
        public static void main(String[] args) {
                STIG stig = new V_220775();
                //running command line interface for V_220775
                cli(stig, args);
        }

}