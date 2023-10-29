package rqcode.stigs.win10_new.RegistryEdit;

public class RegistryEditConst {
    public static final String REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE = " $path = \"%(path)\"\n" +
            "    $attr = %(attr)\n" +
            "    result_value = %(result_value)\n" +
            "    if (!(Test-Path $path)){\n" +
            "        New-Item -Path $path \n" +
            "        New-ItemProperty -Force -Path $registryPath -Name $attr Value $value -Force\n" +
            "    }\n"
            ;

    public static final String REGISTRY_EDIT_SCRIPT_PATTERN_CHECK = "$path = \"%(path)\"\n" +
            "    $attr = %(attr)\n" +
            "    result_value = %(result_value)\n" +
            "    if (Test-Path $path){\n" +
            "    $var1 = Get-ItemPropertyValue -Path $path -Name $attr\n" +
            "    if ($var1 -eq $result_value){\n" +
            "    result = \"OK\"\n" +
            "    }\n" +
            "    }"
            ;



}


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

/*$registryPath = 'HKLM:\SOFTWARE\Policies\Microsoft\Windows\Personalization'
        if (!(Test-Path $registryPath)){
        New-Item -Path 'HKLM:\SOFTWARE\Policies\Microsoft\Windows'
        New-Item -Path 'HKLM:\SOFTWARE\Policies\Microsoft\Windows\Personalization'
        New-ItemProperty -Force -Path 'HKLM:\SOFTWARE\Policies\Microsoft\Windows\Personalization' -Name NoLockScreenCamera -Value 1*/