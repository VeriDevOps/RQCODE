package rqcode.stigs.win10_v3.UserRights;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

public class UserRightsStig4 extends STIG {

        public static final String USER_RIGHTS_ENFORCE_SCRIPT = 
                        "$constantName = \"%(constantName)\"\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                        "Revoke-UserRight $account.SID $constantName\n" +
                        "}\n\n" +
                        "$perteneceDominio = (Get-WmiObject -Class Win32_ComputerSystem).PartOfDomain\n\n" +


                        "if ($perteneceDominio){\n" +
                            "Grant-UserRight 'S-1-5-domain-519' $constantName\n" +
                            "Grant-UserRight 'S-1-5-root domain-512' $constantName\n" +
                            " Grant-UserRight 'S-1-2-0' $constantName\n" +
                        "}else{\n" +
                            "Grant-UserRight 'S-1-5-32-546' SeDenyNetworkLogonRight\n" +
                        "}";
                    
        public static final String USER_RIGHTS_CHECK_SCRIPT = 
                        "$constantName = \"%(constantName)\"\n" +
                        "$result = \"ERROR\"\n" + 
                        "$EnterpriseAdmins = 0\n"  +
                        "$DomainAdmins  = 0\n" +
                        "$Localaccount = 0\n" +
                        "$guest = 0\n" +
                        "$uno = 0\n" +
                        "$otros = 0\n\n" +
                         
                        "$perteneceDominio = (Get-WmiObject -Class Win32_ComputerSystem).PartOfDomain\n" +
                        "$ListAccounts = Get-AccountsWithUserRight $constantName\n" +
                        "Foreach ($account in $ListAccounts)\n" +
                        "{\n" +
                            "if ($perteneceDominio){\n" +
                                "if ($account.SID -eq 'S-1-5-domain-512'){\n" +
                                    "$EnterpriseAdmins = 1\n" +
                                "}elseif ($account.SID -eq 'S-1-5-root-domain-519'){\n" +
                                    "$DomainAdmins = 1\n" +
                                "}elseif ($account.SID -eq 'S-1-2-0'){\n" +
                                    "$Localaccount = 1\n" +
                                "}elseif ($account.SID -eq 'S-1-5-32-546'){\n" +
                                    "$guest = 1\n" +
                                "}elseif ($account.SID -eq 'S-1-5-113'){\n" +
                                    "$uno = 1\n" +
                                "}else{\n" +
                                    "$otros = 1\n" +
                                "}\n" +
                            "}\n" +
                        "}\n\n" +
                        
                        "if ($perteneceDominio){\n" +
                            "if(($EnterpriseAdmins -eq 1) -And ($DomainAdmins -eq 1) -And ($Localaccount -eq 1) -And ($guest -eq 1) -And ($uno -eq 1) -And ($otros -eq 0)){\n" +
                            "$result = \"OK\"\n" +
                            "}\n" +
                        "}else{\n" +
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