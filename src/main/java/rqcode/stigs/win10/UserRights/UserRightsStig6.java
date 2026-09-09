package rqcode.stigs.win10.UserRights;

import rqcode.stigs.STIG;
import rqcode.stigs.win10.WinScriptHelper;

/**
 * Parametrizable class for STIG findings whose "must only be assigned to"
 * set is exactly {Administrators, Users} (well-known SIDs S-1-5-32-544 and
 * S-1-5-32-545), following the same one-class-per-accepted-account-set
 * pattern as UserRightsStig1..5.
 */
public class UserRightsStig6 extends STIG {

        public static final String USER_RIGHTS_ENFORCE_SCRIPT =
                        "$constantName = \"%(constantName)\"\n" +
                        "$ListAccounts = Get-AccountsWithUserRight $constantName\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                        "Revoke-UserRight $account.SID $constantName\n" +
                        "}\n\n" +
                        "Grant-UserRight 'S-1-5-32-544' $constantName\n" +
                        "Grant-UserRight 'S-1-5-32-545' $constantName";

        public static final String USER_RIGHTS_CHECK_SCRIPT =
                        "$constantName = \"%(constantName)\"\n" +
                        "$result = \"ERROR\"\n" +
                        "$ListAccounts = Get-AccountsWithUserRight $constantName\n" +
                        "$admins = 0\n" +
                        "$users = 0\n" +
                        "$otros = 0\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                            "if ($account.SID -eq 'S-1-5-32-544'){\n" +
                                "$admins = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-32-545'){\n" +
                                "$users = 1\n" +
                            "}else{\n" +
                                "$otros = 1" +
                            "}\n" +
                        "}\n\n" +
                        "if (($admins -eq 1) -And ($users -eq 1) -And ($otros -eq 0)){\n" +
                            "$result = \"OK\"\n" +
                        "}\n" +
                        "$result";
        private WinScriptHelper helper = new WinScriptHelper(USER_RIGHTS_CHECK_SCRIPT,
                        USER_RIGHTS_ENFORCE_SCRIPT);

        public WinScriptHelper getHelper() {
                return helper;
        }

        @Override
        public CheckStatus check() {
                setLastCheckStatus(helper.check());
                return getLastCheckStatus();
        }

        @Override
        public EnforcementStatus enforce() {
                setLastEnforcementStatus(helper.enforce());
                return getLastEnforcementStatus();
        }

        public String getShortPath(){
                String path = helper.getEnforceValues().get("path");
                int l = path.lastIndexOf("\\");
                String shortPath = path.substring(0, l);
                return shortPath;
        }

}
