$path = "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\mrxsmb10"
$attr = "Start"
$result_value = "0x00000004 (4)"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result