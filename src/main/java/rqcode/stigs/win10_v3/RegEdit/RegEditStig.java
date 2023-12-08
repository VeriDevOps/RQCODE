package rqcode.stigs.win10_v3.RegEdit;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

public class RegEditStig extends STIG {

        public static final String REGISTRY_EDIT_ENFORCE_SCRIPT = "$path = \"%(path)\"\n" +
                        "$path_short = \"%(path_short)\"\n" +
                        "$attr = \"%(attr)\"\n" +
                        "$result_value = \"%(result_value)\"\n" + 
                        "if (!(Test-Path $path_short)) {\n" +
                         "New-Item -Path $path_short \n" +
                        "}\n"+                      
                        "if (!(Test-Path $path)){\n" +
                        "New-Item -Path $path \n" +
                        "}\n"+
                        "New-ItemProperty -Force -Path $path -Name $attr -Value $result_value \n";

        public static final String REGISTRY_EDIT_CHECK_SCRIPT = "$path = \"%(path)\"\n" +
                        "$attr = \"%(attr)\"\n" +
                        "$result_value = \"%(result_value)\"\n" +
                        "$result = \"ERROR\"\n" +
                        "if (Test-Path $path){\n" +
                        "$Key = Get-Item -LiteralPath $path\r\n" + //
                        "if ($Key.GetValue($attr, $null) -ne $null) {\r\n" + //
                        "$var1 = Get-ItemPropertyValue -Path $path -Name $attr\n" +
                        "if ($var1 -eq $result_value){\n" +
                        "$result = \"OK\"\n" +
                        "}\n" +
                        "}\n" +
                        "}\n" +
                        "$result\n"; // +
                        //"Write-Output \"" + PowerShell.END_SCRIPT_STRING + "\"";
        private WinScriptHelper helper = new WinScriptHelper(REGISTRY_EDIT_CHECK_SCRIPT,
                        REGISTRY_EDIT_ENFORCE_SCRIPT);

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