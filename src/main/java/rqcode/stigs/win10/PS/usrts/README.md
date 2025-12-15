# Necessary utilities for the Windows 10 STIGs requirements cheking and enforcement.

The UserRights RQCODE classes use specific PowerShell commands that comes with the custom module.

The author of this module is Tony Pombo. The script was originially distributed at https://gallery.technet.microsoft.com/Grant-Revoke-Query-user-26e259b0


## Installation

Open PowerShell as administrator

Check path for the Windows modules:

```PowerShell
$env:PSModulePath
```

Install UserRights module:
```PowerShell
cd "path to rqcode/stigs/win10/PS/usrts folder"
cp -r ./urts "C:\Program Files\WindowsPowerShell\Modules"
Import-Module usrts -Verbose
Get-Module -ListAvailable
```

You may see that the usrts module export several commands:
```
ModuleType Version    Name                                ExportedCommands
---------- -------    ----                                ----------------
Script     0.0.5      usrts                               {Revoke-UserRight, Grant-TokenPrivilege, Get-AccountsWith...
```

## Remove UserRights module

```PowerShell
cd "C:\Program Files\WindowsPowerShell\Modules"
Remove-Module usrts
rm -r .\usrts\
Get-Module -ListAvailable
```

You may see that the usrts module disapeared from the available modules

## Troubleshooting

You may need to enable the scripts execution
```PowerShell
Set-ExecutionPolicy RemoteSigned
```

Disable after installation
```PowerShell
Set-ExecutionPolicy Restricted
```