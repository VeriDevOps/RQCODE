package main.java.rqcode.patterns.win10;

import java.io.*;
import java.util.*;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import main.java.rqcode.concepts.CheckableEnforceableRequirement;

/**
 * Instances of this class are requirements related to Windows 10 audit policies. Instances of this utilize auditpol.exe to perform checking and enforcing; that is, they fork auditpol.exe manipulate its input and output. It would be ideal to perform checking and enforcing through Win32 API calls instead, but for the time being this approach works.
 */
@objid ("586a40f7-59f2-467f-be28-581b0d530766")
public abstract class AuditPolicyRequirement extends CheckableEnforceableRequirement {
    /**
     * @return the category parameter for auditpol.exe.
     */
    @objid ("5549fad5-5cdc-4d54-9f0a-4704ffbba85d")
    protected abstract String getCategory();

    /**
     * @return the subcategory parameter for auditpol.exe.
     */
    @objid ("0a5e0400-fd03-474f-b7db-18b495a8de56")
    protected abstract String getSubcategory();

    /**
     * @return the include parameter for auditpol.exe.
     */
    @objid ("7a6fac46-c87e-4f6c-ad66-aba5501d73c6")
    protected abstract String getInclusionSetting();

    /**
     * @return the success parameter for auditpol.exe.
     */
    @objid ("75556833-033b-4aed-a861-1da4a6a7c276")
    protected abstract String getSuccess();

    /**
     * @return the failure parameter for auditpol.exe.
     */
    @objid ("d737615c-acca-40f6-b07a-c1f85cbced02")
    protected abstract String getFailure();

    @objid ("9e38cf44-a70d-42ed-b412-2423ace4cb19")
    @Override
    public CheckStatus check() {
        // some weird behaviour with auditpol had to be dealt with over here
        String category = getCategory();
        String subcategory = getSubcategory();
        String inclusionSetting = getInclusionSetting();
        
        List<Map<String, String>> auditPolicy;
        try {
            auditPolicy = AuditPol.get(null, category, subcategory);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }
        
        if (auditPolicy.isEmpty())
            return CheckStatus.FAIL;
        
        for (Map<String, String> entry : auditPolicy) {
            if (entry.get("Subcategory").equals(subcategory)
                    && entry.get("Inclusion Setting").contains(inclusionSetting))
                return CheckStatus.PASS;
        }
        return CheckStatus.FAIL;
    }

    @objid ("3c34387a-caa5-4736-8f96-3c929d966ccd")
    @Override
    public EnforcementStatus enforce() {
        String category = getCategory();
        String subcategory = getSubcategory();
        String success = getSuccess();
        String failure = getFailure();
        
        try {
            AuditPol.set(null, null, null, category, subcategory, success, failure);
        } catch (Exception e) {
            e.printStackTrace();
            return EnforcementStatus.FAILURE;
        }
        return EnforcementStatus.SUCCESS;
    }

    /**
     * This class acts as a driver to auditpol.exe; its members correspond to the command line use of auditpol.exe.
     */
    @objid ("706dd11a-8a19-49bf-be98-2b7ffd285716")
    static class AuditPol {
        @objid ("3b9d83f6-1bcc-4356-acae-5461ed28692c")
        private static String sanitizeArgument(String arg) {
            if (arg != null && arg.contains(" "))
                arg = String.format("\"%s\"", arg);
            return arg;
        }

        /**
         * An interface to auditpol get subcommand. See https://docs.microsoft.com/en-us/windows-server/administration/windows-commands/auditpol-get.
         * @throws Exception in case auditpol.exe returns an error
         * @param user refer to the link above
         * @param category refer to the link above
         * @param subcategory refer to the link above
         * @return a parsing of the CSV output of auditpol get
         */
        @objid ("ea84e94c-5148-4a60-9411-ad15cb52a480")
        public static List<Map<String, String>> get(String user, String category, String subcategory) throws Exception {
            String auditPolCommand = "auditpol /get";
            if (user != null)
                auditPolCommand += String.format(" /user:%s", sanitizeArgument(user));
            if (category != null)
                auditPolCommand += String.format(" /category:%s", sanitizeArgument(category));
            if (subcategory != null)
                auditPolCommand += String.format(" /subcategory:%s", sanitizeArgument(subcategory));
            auditPolCommand += " /r";
            
            Process auditPol = Runtime.getRuntime().exec(auditPolCommand);
            BufferedReader auditPolOutputReader = new BufferedReader(new InputStreamReader(auditPol.getInputStream()));
            
            List<String> rawAuditPolicy = new LinkedList<String>();
            for (String inputLine = auditPolOutputReader.readLine(); inputLine != null; inputLine = auditPolOutputReader
                    .readLine()) {
                if (!inputLine.trim().isEmpty())
                    rawAuditPolicy.add(inputLine);
            }
            int auditPolExitStatus = auditPol.waitFor();
            if (auditPolExitStatus != 0)
                throw new Exception(String.format("auditpol returned %d", auditPolExitStatus));
            
            String[] auditPolHeaders = rawAuditPolicy.get(0).split(",", -1);
            List<Map<String, String>> ret = new LinkedList<Map<String, String>>();
            for (String line : rawAuditPolicy.subList(1, rawAuditPolicy.size())) {
                String[] auditPolLineFields = line.split(",", -1);
                assert auditPolHeaders.length == auditPolLineFields.length;
            
                Map<String, String> auditPolEntry = new HashMap<String, String>();
                for (int i = 0; i < auditPolHeaders.length; ++i)
                    auditPolEntry.put(auditPolHeaders[i], auditPolLineFields[i]);
                ret.add(auditPolEntry);
            }
            return ret;
        }

        /**
         * An interface to auditpol set subcommand. See https://docs.microsoft.com/en-us/windows-server/administration/windows-commands/auditpol-set.
         * @throws IOException In case the auditpol process could not be forked
         * @throws InterruptedException In case the auditpol process was interrupted
         * @param user refer to the link above
         * @param include refer to the link above
         * @param exclude refer to the link above
         * @param category refer to the link above
         * @param subcategory refer to the link above
         * @param success refer to the link above
         * @param failure refer to the link above
         */
        @objid ("33cd94f3-2aae-41c4-8b25-c06629b4c6ac")
        public static void set(String user, String include, String exclude, String category, String subcategory, String success, String failure) throws IOException, InterruptedException {
            String auditPolCommand = "auditpol /set";
            if (user != null)
                auditPolCommand += String.format(" /user:%s", sanitizeArgument(user));
            if (include != null)
                auditPolCommand += String.format(" /include:%s", sanitizeArgument(include));
            if (exclude != null)
                auditPolCommand += String.format(" /exclude:%s", sanitizeArgument(exclude));
            if (category != null)
                auditPolCommand += String.format(" /category:%s", sanitizeArgument(category));
            if (subcategory != null)
                auditPolCommand += String.format(" /subcategory:%s", sanitizeArgument(subcategory));
            if (success != null)
                auditPolCommand += String.format(" /success:%s", sanitizeArgument(success));
            if (failure != null)
                auditPolCommand += String.format(" /failure:%s", sanitizeArgument(failure));
            
            Process auditPol = Runtime.getRuntime().exec(auditPolCommand);
            
            auditPol.waitFor();
        }

    }

}
