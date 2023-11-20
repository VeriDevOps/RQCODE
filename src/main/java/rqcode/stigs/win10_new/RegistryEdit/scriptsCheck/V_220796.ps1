$path = "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters"
$attr = "DisableIPSourceRouting"
$result_value = "2"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result