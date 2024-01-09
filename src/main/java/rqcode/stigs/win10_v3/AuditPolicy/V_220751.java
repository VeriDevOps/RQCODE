package rqcode.stigs.win10_v3.AuditPolicy;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

import java.util.Map;

/**
 * V_220751: The system must be configured to audit Account Management - User Account Management failures.
 */
public class V_220751 extends AuditPolStig {
        /**
         * Initiating parameters for the check script
        */
        private final static Map<String, String> CHECK_VALUES = Map.of(
                        "id", "V_220751",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "subcat_es", "errores",
                        "subcat_eng", "failure"
                        );

        /**
         * Initiating parameters for the enforce script
         */
        private final static Map<String, String> ENFORCE_VALUES = Map.of(
                        "id", "V_220751",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "parameter", "Failure",
                        "value", "enable"
                        );
        /**
         * Initiating information defining the security requirements from the STIG
         * database
         */
        private final static Map<String, String> INFO = Map.ofEntries(
                        Map.entry("id", "V_220751"),
                        Map.entry("title", "The system must be configured to audit Account Management - User Account Management failures."),
                        Map.entry("date", "2021-08-18"),
                        Map.entry("ruleID", "SV_220751r569187_rule"),
                        Map.entry("severity", "medium"),
                        Map.entry("checktext", "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective.\n\nUse the AuditPol tool to review the current Audit Policy configuration:\nOpen a Command Prompt with elevated privileges (\"Run as Administrator\").\nEnter \"AuditPol /get /category:*\".\n\nCompare the AuditPol settings with the following.  If the system does not audit the following, this is a finding:\n\nAccount Management >> User Account Management - Failure"),
                        Map.entry("checkid", "C-22492r554816_chk"),
                        Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Account Management >> \"Audit User Account Management\" with \"Failure\" selected."),
                        Map.entry("fixid", "F-22481r554817_fix"),
                        Map.entry("description","Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks.  Audit logs are necessary to provide a trail of evidence in case the system or network is compromised.  Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\n\nSecurity Group Management records events such as creating, deleting or changing of security groups, including changes in group members."),
                        Map.entry("iacontrols", "$iacontrols"),
                        Map.entry("version", "WN10-AU-000035")
                        );
                    
        /**
         * Setting up STIG information and initializing the windows script helper with
         * the check and enforce parameters
         */
        public V_220751() {
                setStigInfo(INFO);
                WinScriptHelper helper = this.getHelper();
                helper.setCheckValues(CHECK_VALUES);
                helper.setEnforceValues(ENFORCE_VALUES);
        }

        /**
         * Simple test for the STIG check
         */
        public static void main(String[] args) {
                STIG stig = new V_220751();
                //running command line interface for V_220751
                cli(stig, args);
        }

}