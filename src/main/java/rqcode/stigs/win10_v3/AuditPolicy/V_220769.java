package rqcode.stigs.win10_v3.AuditPolicy;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

import java.util.Map;

/**
 * V_220769: The system must be configured to audit Policy Change - Authorization Policy Change successes.
 */
public class V_220769 extends AuditPolStig {
        /**
         * Initiating parameters for the check script
        */
        private final static Map<String, String> CHECK_VALUES = Map.of(
                        "id", "V_220769",
                        "guid", "{0CCE9231-69AE-11D9-BED3-505054503030}",
                        "subcat_es", "acierto",
                        "subcat_eng", "success"
                        );

        /**
         * Initiating parameters for the enforce script
         */
        private final static Map<String, String> ENFORCE_VALUES = Map.of(
                        "id", "V_220769",
                        "guid", "{0CCE9231-69AE-11D9-BED3-505054503030}",
                        "parameter", "Success",
                        "value", "enable"
                        );
        /**
         * Initiating information defining the security requirements from the STIG
         * database
         */
        private final static Map<String, String> INFO = Map.ofEntries(
                        Map.entry("id", "V_220769"),
                        Map.entry("title", "The system must be configured to audit Policy Change - Authorization Policy Change successes."),
                        Map.entry("date", "2021-08-18"),
                        Map.entry("ruleID", "SV_220769r569187_rule"),
                        Map.entry("severity", "medium"),
                        Map.entry("checktext", "Security Option \\Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\\ must be set to \\Enabled\\ (WN10-SO-000030) for the detailed auditing subcategories to be effective. \\n\\nUse the AuditPol tool to review the current Audit Policy configuration:\\n-Open a Command Prompt with elevated privileges (\\Run as Administrator\\).\\n-Enter \\AuditPol /get /category:*\\.\\n\\nCompare the AuditPol settings with the following. If the system does not audit the following, this is a finding.\\n\\nPolicy Change >> Authorization Policy Change - Success"),
                        Map.entry("checkid", "C-22483r554789_chk"),
                        Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Policy Change >> \\Audit Authorization Policy Change\\ with \\Success\\ selected."),
                        Map.entry("fixid", "F-22472r554790_fix"),
                        Map.entry("description","Allowing autoplay to execute may introduce malicious code to a system.  Autoplay begins reading from a drive as soon as you insert media in the drive.  As a result, the setup file of programs or music on audio media may start.  By default, autoplay is disabled on removable drives, such as the floppy disk drive (but not the CD-ROM drive) and on network drives.  If you enable this policy, you can also disable autoplay on all drives."),
                        Map.entry("iacontrols", "null"),
                        Map.entry("version", "WN10-AU-000107")
                        );
                    
        /**
         * Setting up STIG information and initializing the windows script helper with
         * the check and enforce parameters
         */
        public V_220769() {
                setStigInfo(INFO);
                WinScriptHelper helper = this.getHelper();
                helper.setCheckValues(CHECK_VALUES);
                helper.setEnforceValues(ENFORCE_VALUES);
        }

        /**
         * Simple test for the STIG check
         */
        public static void main(String[] args) {
                STIG stig = new V_220769();

                System.out.println(stig);

                stig.check();
                System.out.println("1st check:" + stig.getLastCheckStatus());
        }

}