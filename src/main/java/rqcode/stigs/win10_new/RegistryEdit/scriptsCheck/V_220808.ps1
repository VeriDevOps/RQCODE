$path = "HKLM:\\SOFTWARE\\Microsoft\\WcmSvc\\wifinetworkmanager\\config"
$attr = "AutoConnectAllowedOEM"
$result_value = "0x00000000 (0)"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result