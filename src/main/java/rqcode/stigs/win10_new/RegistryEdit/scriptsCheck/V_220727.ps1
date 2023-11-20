$path = "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\kernel"
$attr = "DisableExceptionChainValidation"
$result_value = "0x00000000 (0)"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result