package rqcode.stigs.win10_v3.AuditPolicy;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

import java.util.Map;

/**
 * V_220756: The system must be configured to audit Logon/Logoff - Group Membership successes.
 */
public class V_220756 extends AuditPolStig {
        /**
         * Initiating parameters for the check script
        */
        private final static Map<String, String> CHECK_VALUES = Map.of(
                        "id", "V_220756",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "subcat_es", "acierto",
                        "subcat_eng", "success"
                        );

        /**
         * Initiating parameters for the enforce script
         */
        private final static Map<String, String> ENFORCE_VALUES = Map.of(
                        "id", "V_220756",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "parameter", "Success",
                        "value", "enable"
                        );
        /**
         * Initiating information defining the security requirements from the STIG
         * database
         */
        private final static Map<String, String> INFO = Map.ofEntries(
                        Map.entry("id", "V_220756"),
                        Map.entry("title", "The system must be configured to audit Logon/Logoff - Group Membership successes."),
                        Map.entry("date", "2021-08-18"),
                        Map.entry("ruleID", "SV_220756r569187_rule"),
                        Map.entry("severity", "medium"),
                        Map.entry("checktext", "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective. \n\nUse the AuditPol tool to review the current Audit Policy configuration:\nOpen a Command Prompt with elevated privileges (\"Run as Administrator\").\nEnter \"AuditPol /get /category:*\"\n\nCompare the AuditPol settings with the following.  If the system does not audit the following, this is a finding:\n\nLogon/Logoff >> Group Membership - Success"),
                        Map.entry("checkid", "C-22470r554750_chk"),
                        Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Logon/Logoff >> \"Audit Group Membership\" with \"Success\" selected."),
                        Map.entry("fixid", "F-22459r554751_fix"),
                        Map.entry("description","Windows can be configured to automatically sign the user back in after a Windows Update restart.  Some protections are in place to help ensure this is done in a secure fashion; however, disabling this will prevent the caching of credentials for this purpose and also ensure the user is aware of the restart."),
                        Map.entry("iacontrols", "$iacontrols"),
                        Map.entry("version", "WN10-AU-000060")
                        );
                    
        /**
         * Setting up STIG information and initializing the windows script helper with
         * the check and enforce parameters
         */
        public V_220756() {
                setStigInfo(INFO);
                WinScriptHelper helper = this.getHelper();
                helper.setCheckValues(CHECK_VALUES);
                helper.setEnforceValues(ENFORCE_VALUES);
        }

        /**
         * Simple test for the STIG check
         */
        public static void main(String[] args) {
                STIG stig = new V_220756();
                //running command line interface for V_220756
                cli(stig, args);
        }

}