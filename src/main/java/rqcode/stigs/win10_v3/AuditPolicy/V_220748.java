package rqcode.stigs.win10_v3.AuditPolicy;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;
import rqcode.stigs.win10_v3.WinStig;

import java.util.Map;

public class V_220748 extends WinStig {
    private final static WinScriptHelper helper = new WinScriptHelper(
            AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_CHECK, AuditPolicyConst.AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE,
            Map.of(
                    "id", "V_220748",
                    "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                    "subcat_es", "errores",
                    "subcat_eng", "failure"),
            Map.of(
                    "id", "V_220748",
                    "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                    "parameter", "Failure",
                    "value", "enable"));
    
    private final static Map <String, String> info = Map.ofEntries(
        Map.entry("checkid", "C-22463r554729_chk"),
        Map.entry("checktext", "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective.\n\nUse the AuditPol tool to review the current Audit Policy configuration:\nOpen a Command Prompt with elevated privileges (\"Run as Administrator\").\nEnter \"AuditPol /get /category:*\".\n\nCompare the AuditPol settings with the following. If the system does not audit the following, this is a finding:\n\nAccount Logon >> Credential Validation - Failure"), 
        Map.entry("description", "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks.  Audit logs are necessary to provide a trail of evidence in case the system or network is compromised.  Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.\n\nCredential validation records events related to validation tests on credentials for a user account logon."), 
        Map.entry("fixid", "F-22452r554730_fix"),
        Map.entry( "fixtext", "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Account Logon >> \"Audit Credential Validation\" with \"Failure\" selected."),
        Map.entry("iacontrols", "null"), 
        Map.entry("id", "V-220748"), 
        Map.entry("ruleID", "SV-220748r569187_rule"), 
        Map.entry("severity", "medium"), 
        Map.entry("title", "The system must be configured to audit Account Logon - Credential Validation failures."),
        Map.entry("version", "WN10-AU-000005")
        );

    public V_220748() {
        super(info);
    }

    @Override
    public CheckStatus check() {
        
        setLastCheckStatus(helper.check());

        return getLastCheckStatus();
    }

    @Override
    public EnforcementStatus enforce() {   
        
        setLastEnforcementStatus(helper.enforce());
        return  getLastEnforcementStatus();
    }

    public static void main(String[] args) {
        STIG stig = new V_220748();

        stig.check();
        System.out.println(stig);
    }

}