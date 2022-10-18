package rqcode.stigs.win10_new.RegistryEdit;

public class RegistryEditConst {
    public static final String REGISTRY_EDIT_SCRIPT_PATTERN = " $registryPath = \"%s\"\n" +
            "    $name = \"%s\"\n" +
            "    $type = \"%s\"\n" +
            "    $value = %s\n" +
            "    if (!(Test-Path $registryPath)){\n" +
            "        New-Item -Path $registryPath -Force\n" +
            "        New-ItemProperty -Path $registryPath -Name $name -PropertyType $type -Value $value -Force\n" +
            "    }\n" +
            "    else{\n" +
            "        New-ItemProperty -Path $registryPath -Name $name -PropertyType $type -Value $value -Force\n";

}