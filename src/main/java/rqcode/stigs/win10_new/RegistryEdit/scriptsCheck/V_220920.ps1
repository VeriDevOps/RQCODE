$path = "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System"
$attr = "InactivityTimeoutSecs"
$result_value = "900"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result