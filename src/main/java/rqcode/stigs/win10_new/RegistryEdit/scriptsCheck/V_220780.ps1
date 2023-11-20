$path = "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\Security"
$attr = "MaxSize"
$result_value = "0x000fa000 (1024000) "
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result