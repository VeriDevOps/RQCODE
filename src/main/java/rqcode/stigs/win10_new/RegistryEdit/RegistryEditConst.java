package rqcode.stigs.win10_new.RegistryEdit;

public class RegistryEditConst {
    public static final String REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE = " $path = \"%(path)\"\n" +
            "    $attr = %(attr)\n" +
            "    $result_value = %(result_value)\n" +
            "    if (!(Test-Path $path)){\n" +
            "        New-Item -Path $path \n" +
            "        New-ItemProperty -Force -Path $path -Name $attr -Value $result_value \n" +
            "    }\n"
            ;


    public static final String REGISTRY_EDIT_SCRIPT_PATTERN_CHECK = "$path = \"%(path)\"\n" +
            "    $attr = %(attr)\n" +
            "    $result_value = %(result_value)\n" +
            "    $result = \"ERROR\"" +
            "    if (Test-Path $path){\n" +
            "    $var1 = Get-ItemPropertyValue -Path $path -Name $attr\n" +
            "    if ($var1 -eq $result_value){\n" +
            "    $result = \"OK\"\n" +
            "    }\n" +
            "    }" +
            "    $result"
            ;


    /*
    ## v-63545
$path = "HKLM:\SOFTWARE\Policies\Microsoft\Windows\Personalization"
$attr = "NoLockScreenCamera"
$result = "ERROR"

if (Test-Path $path) {
    $var1 = Get-ItemPropertyValue -Path $path -Name $attr
    if ($var1 -eq 1){
        $result = "OK"
    }
}

     */

}


/*$path = "HKLM:\SOFTWARE\Policies\Microsoft\Windows\Personalization"
        $attr = "NoLockScreenCamera"
        $result = "ERROR"

        if (Test-Path $path) {
        $var1 = Get-ItemPropertyValue -Path $path -Name $attr
        if ($var1 -eq 1){
        $result = "OK"
        }
        }
*/