$path = "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\LDAP"
$attr = "LDAPClientIntegrity"
$result_value = "1"
$result = "ERROR"
if (Test-Path $path){
$var1 = Get-ItemPropertyValue -Path $path -Name $attr
if ($var1 -eq $result_value){
$result = "OK"
}
}
$result