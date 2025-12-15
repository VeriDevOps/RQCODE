package rqcode.stigs.win10.AuditPolicy;

import rqcode.stigs.STIG;
import rqcode.stigs.win10.WinScriptHelper;

import java.util.Map;

/**
 * V_220766: The system must be configured to audit Object Access - Removable Storage successes.
 */
public class V_220766 extends AuditPolStig {
        /**
         * Initiating parameters for the check script
        */
        private final static Map<String, String> CHECK_VALUES = Map.of(
                        "id", "V_220766",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "subcat_es", "acierto",
                        "subcat_eng", "success"
                        );

        /**
         * Initiating parameters for the enforce script
         */
        private final static Map<String, String> ENFORCE_VALUES = Map.of(
                        "id", "V_220766",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "parameter", "Success",
                        "value", "enable"
                        );
        /**
         * Initiating information defining the security requirements from the STIG
         * database
         */
        private final static Map<String, String> INFO = Map.ofEntries(
                        Map.entry("id", "V_220766"),
                        Map.entry("title", "The system must be configured to audit Object Access - Removable Storage successes."),
                        Map.entry("date", "2021-08-18"),
                        Map.entry("ruleID", "SV_220766r569187_rule"),
                        Map.entry("severity", "medium"),
                        Map.entry("checktext", "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective.\n\nUse the AuditPol tool to review the current Audit Policy configuration:\nOpen a Command Prompt with elevated privileges (\"Run as Administrator\").\nEnter \"AuditPol /get /category:*\"\n\nCompare the AuditPol settings with the following. If the system does not audit the following, this is a finding:\n\nObject Access >> Removable Storage - Success\n\nSome virtual machines may generate excessive audit events for access to the virtual hard disk itself when this setting is enabled. This may be set to Not Configured in such cases and would not be a finding.  This must be documented with the ISSO to include mitigations such as monitoring or restricting any actual removable storage connected to the VM."),
                        Map.entry("checkid", "C-22485r554795_chk"),
                        Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Object Access >> \"Audit Removable Storage\" with \"Success\" selected."),
                        Map.entry("fixid", "F-22474r554796_fix"),
                        Map.entry("description","Inappropriate granting of user rights can provide system, administrative, and other high level capabilities.\n\nAccounts with the \"Create global objects\" user right can create objects that are available to all sessions, which could affect processes in other users' sessions."),
                        Map.entry("iacontrols", "$iacontrols"),
                        Map.entry("version", "WN10-AU-000090")
                        );
                    
        /**
         * Setting up STIG information and initializing the windows script helper with
         * the check and enforce parameters
         */
        public V_220766() {
                setStigInfo(INFO);
                WinScriptHelper helper = this.getHelper();
                helper.setCheckValues(CHECK_VALUES);
                helper.setEnforceValues(ENFORCE_VALUES);
        }

        /**
         * Simple test for the STIG check
         */
        public static void main(String[] args) {
                STIG stig = new V_220766();
                //running command line interface for V_220766
                cli(stig, args);
        }

}