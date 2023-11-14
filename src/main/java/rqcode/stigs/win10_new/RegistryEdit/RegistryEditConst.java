package rqcode.stigs.win10_new.RegistryEdit;

public class RegistryEditConst {
    public static final String REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE = " $path = \"%(path)\"\n" +
            "    $path_short = %(path_short)\n" +
            "    $attr = %(attr)\n" +
            "    $result_value = \"%(result_value)\"\n" +
            "    if (!(Test-Path $path)){\n" +
            "        New-Item -Path $path_short \n" +
            "        New-Item -Path $path \n" +
            "        New-ItemProperty -Force -Path $path -Name $attr -Value $result_value \n" +
            "    }\n"
            ;


    public static final String REGISTRY_EDIT_SCRIPT_PATTERN_CHECK = "$path = \"%(path)\"\n" +
            "    $attr = \"%(attr)\"\n" +
            "    $result_value = \"%(result_value)\"\n" +
            "    $result = \"ERROR\"\n" +
            "    if (Test-Path $path){\n" +
            "    $var1 = Get-ItemPropertyValue -Path $path -Name $attr\n" +
            "    if ($var1 -eq $result_value){\n" +
            "    $result = \"OK\"\n" +
            "    }\n" +
            "    }\n" +
            "    $result"
            ;
}