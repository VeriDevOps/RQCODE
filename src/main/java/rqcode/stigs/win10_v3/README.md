# Necessary utilities for the Windows 10 STIGs requirements cheking and enforcement.

### Installation

Check path for the Windows modules:
```PowerShell
$env:PSModulePath
```

Install UserRights module:
```PowerShell
cd "path to rqcode/stigs/win10/PS folder"
cp -r ./urts "C:\Program Files\WindowsPowerShell\Modules"
Import-Module usrts -Verbose
Get-Module -ListAvailable
```

Remove UserRights module:
```PowerShell
cd "C:\Program Files\WindowsPowerShell\Modules"
Remove-Module usrts
rm -r .\usrts\
Get-Module -ListAvailable
```
### Troubleshooting

You may need to enable the scripts execution
```PowerShell
Set-ExecutionPolicy RemoteSigned
```

Disable after installation
```PowerShell
Set-ExecutionPolicy Restricted
```