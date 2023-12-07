package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_new.patterns.STIGPattern;
import rqcode.stigs.win10_v3.WinScriptHelper;

public class RegEditStig extends STIG {

    public static final String REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE = "$path = \"%(path)\"\n" +
            "$path_short = \"%(path_short)\"\n" +
            "$attr = \"%(attr)\"\n" +
            "$result_value = \"%(result_value)\"\n" +
            "if (!(Test-Path $path)){\n" +
            "New-Item -Path $path_short \n" +
            "New-Item -Path $path \n" +
            "New-ItemProperty -Force -Path $path -Name $attr -Value $result_value \n" +
            "}\n"
            ;


    public static final String REGISTRY_EDIT_SCRIPT_PATTERN_CHECK = "$path = \"%(path)\"\n" +
            "$attr = \"%(attr)\"\n" +
            "$result_value = \"%(result_value)\"\n" +
            "$result = \"ERROR\"\n" +
            "if (Test-Path $path){\n" +
            "$var1 = Get-ItemPropertyValue -Path $path -Name $attr\n" +
            "if ($var1 -eq $result_value){\n" +
            "$result = \"OK\"\n" +
            "}\n" +
            "}\n" +
            "$result\n" +
            "Write-Output \"" + PowerShell.END_SCRIPT_STRING + "\""
            ;
        private WinScriptHelper helper = new WinScriptHelper(REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                        REGISTRY_EDIT_SCRIPT_PATTERN_CHECK);

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


}