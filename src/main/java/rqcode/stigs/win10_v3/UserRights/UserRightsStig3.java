package rqcode.stigs.win10_v3.UserRights;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

public class UserRightsStig3 extends STIG {

        public static final String USER_RIGHTS_ENFORCE_SCRIPT = 
                        "$administrators = \"%(administrators)\"\n" +
                        "$localService = \"%(localService)\"\n" +
                        "$service = \"%(service)\"\n" +
                        "$networkService = \"%(networkService)\"\n" +
                        "$constantName = \"%(constantName)\"\n" +
                        "$ListAccounts = Get-AccountsWithUserRight $constantName\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                        "Revoke-UserRight $account.SID $constantName\n" +
                        "}\n\n" +
                        "Grant-UserRight $administrators $constantName\n" +
                        "Grant-UserRight $localService $constantName\n" +
                        "Grant-UserRight $service $constantName\n" +
                        "Grant-UserRight $networkService $constantName";

        public static final String USER_RIGHTS_CHECK_SCRIPT = 
                        "$constantName = \"%(constantName)\"\n" +
                        "$result = \"ERROR\"\n" + 
                        "$admins = 0\n"  +
                        "$otros = 0\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                            "if ($account.SID -eq 'S-1-5-32-544'){\n" +
                                "$admins = 1\n" +
                            "}else{\n" +
                                "$otros = 1" +
                            "}\n" +
                        "}\n" +
                        "if (($admins -eq 1) -And ($otros -eq 0)){\n" +
                            "$result = \"OK\"\n" +
                        "}"; 
                        // +
                        //"Write-Output \"" + PowerShell.END_SCRIPT_STRING + "\"";
        private WinScriptHelper helper = new WinScriptHelper(USER_RIGHTS_ENFORCE_SCRIPT,
                        USER_RIGHTS_CHECK_SCRIPT);

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