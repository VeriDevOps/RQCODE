$path = "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\MSV1_0"
$attr = "NTLMMinServerSec"
$result_value = "0x20080000 (537395200)"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result