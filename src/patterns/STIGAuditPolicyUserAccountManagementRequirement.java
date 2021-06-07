package patterns;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;
import stig.STIG;

public abstract class STIGAuditPolicyUserAccountManagementRequirement extends STIG
        implements CheckableRequirement, EnforcableRequirement {

    
    /** 
     * @return String
     */
    public String description() {
        return "Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.";
    }

    
    /** 
     * @return String
     */
    public String checkText() {
        return "Security Option \"Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings\" must be set to \"Enabled\" (WN10-SO-000030) for the detailed auditing subcategories to be effective."
                + "\n" + "Use the AuditPol tool to review the current Audit Policy configuration:" + "\n"
                + "Open a Command Prompt with elevated privileges (\"Run as Administrator\")." + "\n"
                + "Enter \"AuditPol /get /category:*\"." + "\n"
                + "Compare the AuditPol settings with the following. If the system does not audit the following, this is a finding:"
                + "\n" + String.format("Account Management >> User Account Management - %s", getSetting());
    }

    
    /** 
     * @return String
     */
    public String fixText() {
        return String.format(
                "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Account Management >> \"Audit User Account Management\" with \"%s\" selected.",
                getSetting());
    }

    
    /** 
     * @param check(
     * @return String
     */
    abstract String getSetting();

    
    /** 
     * @return CheckStatus
     */
    public CheckStatus check() {
        String setting = getSetting();
        try {
            Process auditPol = Runtime.getRuntime().exec("auditpol /get /subcategory:\"User Account Management\" /r");
            // Possible race condition here
            BufferedReader auditPolOutputReader = new BufferedReader(new InputStreamReader(auditPol.getInputStream()));

            LinkedList<String> auditPolOutput = new LinkedList<String>();
            for (String inputLine = auditPolOutputReader.readLine(); inputLine != null; inputLine = auditPolOutputReader
                    .readLine()) {
                if (!inputLine.trim().isEmpty())
                    auditPolOutput.add(inputLine);
            }

            String[] auditPolOutputHeaders = auditPolOutput.get(0).split(",", -1);
            String[] auditPolOutputFields = auditPolOutput.get(1).split(",", -1);

            assert auditPolOutputHeaders.length == auditPolOutputFields.length;

            HashMap<String, String> userAccountManagementAuditPolicy = new HashMap<String, String>();
            for (int i = 0; i < auditPolOutputHeaders.length; i++)
                userAccountManagementAuditPolicy.put(auditPolOutputHeaders[i], auditPolOutputFields[i]);

            if (userAccountManagementAuditPolicy.get("Inclusion Setting").contains(setting))
                return CheckStatus.PASS;
            else
                return CheckStatus.FAIL;

        } catch (IOException e) {
            System.out.println(e);
            return CheckStatus.INCOMPLETE;
        }
    }

    
    /** 
     * @return EnforcementStatus
     */
    public EnforcementStatus enforce() {
        try {
            Process auditPol = Runtime.getRuntime().exec(
                    String.format("auditpol /set /subcategory:\"User Account Management\" /%s:enable", getSetting()));
            
            return EnforcementStatus.SUCCESS;
        } catch (IOException e) {
            System.out.println(e);
            return EnforcementStatus.FAILURE;
        }
    }
}
