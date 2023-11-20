$path = "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CloudContent"
$attr = "DisableWindowsConsumerFeatures"
$result_value = "0x00000001 (1)"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result