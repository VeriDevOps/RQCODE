$path = "HKLM:\\Software\\Policies\\Microsoft\\Windows\\Kernel DMA Protectio"
$attr = "DeviceEnumerationPolicy"
$result_value = "0"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result