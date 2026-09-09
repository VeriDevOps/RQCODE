package rqcode.stigs.win10.UserRights;

import rqcode.stigs.STIG;
import rqcode.stigs.win10.WinScriptHelper;

/**
 * Parametrizable class for STIG findings whose "must only be assigned to"
 * set is {Administrators, LOCAL SERVICE, NT SERVICE\autotimesvc}.
 *
 * Administrators (S-1-5-32-544) and LOCAL SERVICE (S-1-5-19) are matched by
 * their well-known SIDs, as in UserRightsStig1..6. NT SERVICE\autotimesvc is
 * a per-service virtual account whose SID is derived from the service name
 * (not a fixed well-known SID), so it is matched by its resolved account
 * name instead. Per the STIG's own check text this account was only added
 * to the accepted set in the Windows 10 v1909 cumulative update, so on
 * earlier builds its absence should not by itself be treated as a finding
 * -- a caveat this class does not attempt to detect the build number for.
 */
public class UserRightsStig7 extends STIG {

        public static final String USER_RIGHTS_ENFORCE_SCRIPT =
                        "$constantName = \"%(constantName)\"\n" +
                        "$ListAccounts = Get-AccountsWithUserRight $constantName\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                        "Revoke-UserRight $account.SID $constantName\n" +
                        "}\n\n" +
                        "Grant-UserRight 'S-1-5-32-544' $constantName\n" +
                        "Grant-UserRight 'S-1-5-19' $constantName\n" +
                        "Grant-UserRight 'NT SERVICE\\autotimesvc' $constantName";

        public static final String USER_RIGHTS_CHECK_SCRIPT =
                        "$constantName = \"%(constantName)\"\n" +
                        "$result = \"ERROR\"\n" +
                        "$ListAccounts = Get-AccountsWithUserRight $constantName\n" +
                        "$admins = 0\n" +
                        "$localService = 0\n" +
                        "$autoTimeSvc = 0\n" +
                        "$otros = 0\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                            "if ($account.SID -eq 'S-1-5-32-544'){\n" +
                                "$admins = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-19'){\n" +
                                "$localService = 1\n" +
                            "}elseif ($account.Account -eq 'NT SERVICE\\autotimesvc'){\n" +
                                "$autoTimeSvc = 1\n" +
                            "}else{\n" +
                                "$otros = 1" +
                            "}\n" +
                        "}\n\n" +
                        "if (($admins -eq 1) -And ($localService -eq 1) -And ($otros -eq 0)){\n" +
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
