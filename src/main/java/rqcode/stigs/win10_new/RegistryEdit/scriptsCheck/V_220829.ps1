$path = "HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\policies\\Explorer"
$attr = "NoDriveTypeAutoRun"
$result_value = "0x000000ff (255)"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result