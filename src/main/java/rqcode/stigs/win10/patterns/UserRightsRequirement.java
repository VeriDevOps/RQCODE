package rqcode.stigs.win10.patterns;

import rqcode.concepts.CheckableEnforceableRequirement;
import rqcode.stigs.STIG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class UserRightsRequirement extends STIG {
    public static final String CHECK_TEXT_TEMPLATE = "Verify the effective setting in Local Group Policy Editor.\n" +
            "\n" +
            "Run \"gpedit.msc\".\n" +
            "\n" +
            "Navigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment.\n" +
            "\n" +
            "If any groups or accounts other than the following are granted the \"%s\" user right";

    public static final String FIX_TEXT_TEMPLATE = "Configure the policy value for Computer Configuration >> Windows Settings >> Security Settings >> Local Policies >> User Rights Assignment >> %s";

    private static final String COMMAND_TEMPLATE = "$ListAccounts = Get-AccountsWithUserRight %s\n" +
            "    Foreach ($account in $ListAccounts)\n" +
            "    {\n" +
            "        Revoke-UserRight $account.SID %s\n" +
            "    }\n%s";

    abstract protected String getOption();

    abstract protected String getInclusionSetting();

    abstract protected String getListAccountPrivilege();

    abstract protected String getGrantUserRights();


    protected abstract String getCheckTextAdditional();

    protected abstract String getFixTextAdditional();

    @Override
    public String checkText() {
        return String.format(CHECK_TEXT_TEMPLATE, getOption()) + getCheckTextAdditional();
    }

    @Override
    public String fixText() {
        return String.format(FIX_TEXT_TEMPLATE, getOption()) + getFixTextAdditional();
    }

    @Override
    public CheckStatus check() {
        String privilege = getListAccountPrivilege();
        String grantUser = getGrantUserRights();

        String inclusionSetting = getInclusionSetting();
        String option = getOption();

        List<Map<String, String>> userRights;
        try {
            userRights = UserRights.get(privilege, grantUser);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }

        if (userRights.isEmpty())
            return CheckStatus.FAIL;

        for (Map<String, String> entry : userRights) {
            if (entry.get("Option").equals(option)
                    && entry.get("Inclusion Setting").contains(inclusionSetting))
                return CheckStatus.PASS;
        }
        return CheckStatus.FAIL;
    }

    @Override
    public EnforcementStatus enforce() {
        String privilege = getListAccountPrivilege();
        String grantUser = getGrantUserRights();

        try {
            UserRights.set(privilege, grantUser);
        } catch (Exception e) {
            e.printStackTrace();
            return EnforcementStatus.FAILURE;
        }
        return EnforcementStatus.SUCCESS;
    }

    static class UserRights {
        private static String prepareCommand(String privilege, String grantUser) {
            return String.format(COMMAND_TEMPLATE, privilege, privilege, grantUser);
        }

        static public List<Map<String, String>> get(String privilege, String grantUser) throws Exception {
            String userRightsCommand = prepareCommand(privilege, grantUser);

            Process userRightsProcess = Runtime.getRuntime().exec(userRightsCommand);
            BufferedReader userRightsOutputReader = new BufferedReader(new InputStreamReader(userRightsProcess.getInputStream()));

            List<String> rawUserRights = new LinkedList<>();
            for (String inputLine = userRightsOutputReader.readLine(); inputLine != null; inputLine = userRightsOutputReader
                    .readLine()) {
                if (!inputLine.trim().isEmpty())
                    rawUserRights.add(inputLine);
            }
            int userRightsExitStatus = userRightsProcess.waitFor();
            if (userRightsExitStatus != 0)
                throw new Exception(String.format("command returned %d", userRightsExitStatus));

            String[] userRightsHeaders = rawUserRights.get(0).split(",", -1);
            List<Map<String, String>> ret = new LinkedList<>();
            for (String line : rawUserRights.subList(1, rawUserRights.size())) {
                String[] userRightsLineFields = line.split(",", -1);
                assert userRightsHeaders.length == userRightsLineFields.length;

                Map<String, String> userRightsEntry = new HashMap<>();
                for (int i = 0; i < userRightsHeaders.length; ++i)
                    userRightsEntry.put(userRightsHeaders[i], userRightsLineFields[i]);
                ret.add(userRightsEntry);
            }
            return ret;
        }

        static public void set(String privilege, String grantUser) throws IOException, InterruptedException {
            String userRightsCommand = prepareCommand(privilege, grantUser);
            Process userRightsProcess = Runtime.getRuntime().exec(userRightsCommand);
            userRightsProcess.waitFor();
        }
    }
}

