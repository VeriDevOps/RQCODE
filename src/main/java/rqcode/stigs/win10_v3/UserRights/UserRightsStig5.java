package rqcode.stigs.win10_v3.UserRights;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

public class UserRightsStig5 extends STIG {

        public static final String USER_RIGHTS_ENFORCE_SCRIPT = 
                        "$constantName = \"%(constantName)\"\n" +
                        "$ListAccounts = Get-AccountsWithUserRight $constantName\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                        "Revoke-UserRight $account.SID $constantName\n" +
                        "}\n\n" +
                        "Grant-UserRight 'S-1-5-32-544' $constantName\n" +
                        "Grant-UserRight 'S-1-5-6' $constantName\n" +
                        "Grant-UserRight 'S-1-5-20' $constantName\n" +
                        "Grant-UserRight 'S-1-5-domain-512' $constantName\n" +
                        "Grant-UserRight 'S-1-5-root-domain-519' $constantName\n" +
                        "Grant-UserRight 'S-1-5-32-545' $constantName\n" +
                        "Grant-UserRight 'S-1-5-32-546' $constantName\n" +
                        "Grant-UserRight 'S-1-5-113' $constantName\n" +
                        "Grant-UserRight 'S-1-2-0' $constantName\n" +
                        "Grant-UserRight 'S-1-5-19' $constantName";

        public static final String USER_RIGHTS_CHECK_SCRIPT = 
                        "$constantName = \"%(constantName)\"\n" +
                        "$result = \"ERROR\"\n" + 
                        "$ListAccounts = Get-AccountsWithUserRight $constantName\n" +
                        "$admins = 0\n" +
                        "$service = 0\n" +
                        "$netService = 0\n" +
                        "$localService = 0\n" +
                        "$enterpriseAdmins = 0\n" +
                        "$domainAdmins = 0\n"  +
                        "$users = 0\n" +
                        "$guests = 0\n" +
                        "$uno = 0\n"  +
                        "$localAccount = 0\n"  +
                        "$otros = 0\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                            "if ($account.SID -eq 'S-1-5-32-544'){\n" +
                                "$admins = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-6'){\n" +
                                "$service = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-20'){\n" +
                                "$netService = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-19'){\n" +
                                "$localService = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-domain-512'){\n" +
                                "$enterpriseAdmins = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-32-545'){\n" +
                                "$users = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-root-domain-519'){\n" +
                                "$domainAdmins = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-32-546'){\n" +
                                "$guests = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-5-113'){\n" +
                                "$uno = 1\n" +
                            "}elseif ($account.SID -eq 'S-1-2-0'){\n" +
                                "$localAccount = 1\n" +
                            "}else{\n" +
                                "$otros = 1" +
                            "}\n" +
                        "}\n\n" +
                        
                        "if (($admins -eq 1) -Or ($service -eq 1) -Or ($netService -eq 1) -Or\n" +
                        "($localService -eq 1) -Or ($enterpriseAdmins -eq 1) -Or ($users -eq 1) -Or ($domainAdmins -eq 1) -Or ($guests -eq 1) -Or\n" +
                         "($uno -eq 1) -Or ($localAccount -eq 1) -And ($otros -eq 0)){\n" +
                                "$result = \"OK\"\n" +
                        "}\n" +
                        "$result"; 
                        // +
                        //"Write-Output \"" + PowerShell.END_SCRIPT_STRING + "\"";
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