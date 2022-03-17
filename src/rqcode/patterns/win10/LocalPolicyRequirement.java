
package patterns;

import stig.*;
import java.util.*;
import java.io.*;

public abstract class LocalPolicyRequirement extends CheckableEnforceableRequirement {
    static class LocalPol {
        static private String sanitizeArgument(String arg) {
            if (arg != null && arg.contains(" "))
                arg = String.format("\"%s\"", arg);
            return arg;
        }

        static public List<Map<String, String>> get(String user, String category, String subcategory) throws Exception {

            String localpolCommand = "localpol /get";
            if (user != null)
                localpolCommand += String.format(" /user:%s", sanitizeArgument(user));
            if (category != null)
                localpolCommand += String.format(" /category:%s", sanitizeArgument(category));
            if (subcategory != null)
                localpolCommand += String.format(" /subcategory:%s", sanitizeArgument(subcategory));
            localpolCommand += " /r";

            Process localPol = Runtime.getRuntime().exec(localpolCommand);
            BufferedReader localPolOutputReader = new BufferedReader(new InputStreamReader(localPol.getInputStream()));

            List<String>  rawLocalPolicy = new LinkedList<>();
            for (String inputLine = localPolOutputReader.readLine(); inputLine != null; inputLine = localPolOutputReader
                    .readLine()) {
                if (!inputLine.trim().isEmpty())
                    rawLocalPolicy .add(inputLine);
            }
            int localPolExitStatus = localPol.waitFor();
            if (localPolExitStatus != 0)
                throw new Exception(String.format("localpol returned %d", localPolExitStatus));

            String[] locakPolHeaders =  rawLocalPolicy .get(0).split(",", -1);
            List<Map<String, String>> ret = new LinkedList<>();
            for (String line :  rawLocalPolicy .subList(1,  rawLocalPolicy .size())) {
                String[] localPolLineFields = line.split(",", -1);
                assert locakPolHeaders.length == localPolLineFields.length;

                Map<String, String> localPolEntry = new HashMap<>();
                for (int i = 0; i < locakPolHeaders.length; ++i)
                    localPolEntry.put(locakPolHeaders[i], localPolLineFields[i]);
                ret.add(localPolEntry);
            }
            return ret;
        }

        static public void set(String user, String include, String exclude, String category, String subcategory,
                               String success, String failure) throws IOException, InterruptedException {
            String localPolCommand = "localpol /set";
            if (user != null)
                localPolCommand += String.format(" /user:%s", sanitizeArgument(user));
            if (include != null)
                localPolCommand += String.format(" /include:%s", sanitizeArgument(include));
            if (exclude != null)
                localPolCommand += String.format(" /exclude:%s", sanitizeArgument(exclude));
            if (category != null)
                localPolCommand += String.format(" /category:%s", sanitizeArgument(category));
            if (subcategory != null)
                localPolCommand += String.format(" /subcategory:%s", sanitizeArgument(subcategory));
            if (success != null)
                localPolCommand += String.format(" /success:%s", sanitizeArgument(success));
            if (failure != null)
                localPolCommand += String.format(" /failure:%s", sanitizeArgument(failure));

            Process localPol = Runtime.getRuntime().exec(localPolCommand);

            localPol.waitFor();
        }
    }

    abstract protected String getCategory();

    abstract protected String getSubcategory();

    abstract protected String getInclusionSetting();

    abstract protected String getSuccess();

    abstract protected String getFailure();

    @Override
    public CheckStatus check() {
        //some weird behaviour with localpol had to be dealt with over here
        String category = getCategory();
        String subcategory = getSubcategory();
        String inclusionSetting = getInclusionSetting();

        List<Map<String, String>> localPolicy;
        try {
            localPolicy = LocalPol.get(null, category, subcategory);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }

        if (localPolicy.isEmpty())
            return CheckStatus.FAIL;

        for (Map<String, String> entry : localPolicy) {
            if (entry.get("Subcategory").equals(subcategory)
                    && entry.get("Inclusion Setting").contains(inclusionSetting))
                return CheckStatus.PASS;
        }
        return CheckStatus.FAIL;
    }

    @Override
    public EnforcementStatus enforce() {
        String category = getCategory();
        String subcategory = getSubcategory();
        String success = getSuccess();
        String failure = getFailure();

        try {
            LocalPol.set(null, null, null, category, subcategory, success, failure);
        } catch (Exception e) {
            e.printStackTrace();
            return EnforcementStatus.FAILURE;
        }
        return EnforcementStatus.SUCCESS;
    }
}

