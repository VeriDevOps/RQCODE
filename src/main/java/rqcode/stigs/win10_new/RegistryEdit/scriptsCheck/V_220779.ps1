$path = "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\Application"
$attr = "MaxSize"
$result_value = "0x00008000 (32768) (or greater)"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result