[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=VeriDevOps_RQCODE&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=VeriDevOps_RQCODE)

# VeriDevOps RQCODE Patterns

This repository contains Java implementation of Requirement as Code concept, where requirements were intiated based on suggestions provided by Fagor Electrodoméstico, S. Coop.

## Why Java?

No specific reason. The core idea of this implementation is to capture the object oriented nature of requirements in the FAGOR case. Any other language supporting object oriented programming would be just as fine.

However, it is worth noting that c++/C# would perhaps be a better choice here since requirements are written for Windows and win32 API would come in handy.

## Description of implemented STIGS  

* **v-63447**	

Computer Configuration	Windows Settings	 Security Settings	Advanced Audit Policy Configuration.	System Audit Policies 	Account Management	Audit User Account Management" with "Failure" selected	Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.

* **v-63449**	

Computer Configuration	Windows Settings	 Security Settings	Advanced Audit Policy Configuration.	System Audit Policies 	Account Management	 "Audit User Account Management" with "Success" selected	Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.

* **v-63463**	

Computer Configuration	Windows Settings	 Security Settings	Advanced Audit Policy Configuration.	System Audit Policies 	Logon/Logoff	"Audit Logon" with "Failure" selected.	Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed

* **v-63467**	

Computer Configuration	Windows Settings	 Security Settings	Advanced Audit Policy Configuration.	System Audit Policies 	Logon/Logoff	 "Audit Logon" with "Success" selected	Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed

* **v-63647**	

Computer Configuration	Windows Settings	 Security Settings	Local Policies	Security Options	"Domain member: Digitally sign secure channel data (when possible)" to "Enabled".		Requests sent on the secure channel are authenticated, and sensitive information (such as passwords) is encrypted, but the channel is not integrity checked. If this policy is enabled, outgoing secure channel traffic will be signed.

* **v-63703**	

Computer Configuration	Windows Settings	 Security Settings	Local Policies	Security Options	"Microsoft network client: Digitally sign communications (always)" to "Enabled".		The server message block (SMB) protocol provides the basis for many network operations. Digitally signed SMB packets aid in preventing man-in-the-middle attacks. If this policy is enabled, the SMB client will only communicate with an SMB server that performs SMB packet signing.

* **v-63863**	

Computer Configuration	Windows Settings	 Security Settings	Local Policies	User Rights Assignment	"Create permanent shared objects" to be defined but containing no entries (blank).		Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the "Create permanent shared objects" user right could expose sensitive data by creating shared objects.

* **v-63931**	

Computer Configuration	Windows Settings	 Security Settings	Local Policies	User Rights Assignment	"""Modify firmware environment values"" to only include the following groups or accounts:

Administrators"		Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the "Modify firmware environment values" user right can change hardware configuration environment variables. This could result in hardware failures or a DoS.

* **v-63851**	Computer Configuration	Windows Settings	 Security Settings	Local Policies	User Rights Assignment	"""Allow log on locally"" to only include the following groups or accounts:

Administrators
Users"		Inappropriate granting of user rights can provide system, administrative, and other high-level capabilities. Accounts with the "Allow log on locally" user right can log on interactively to a system.

* **v-63843**



Computer Configuration	Windows Settings	 Security Settings	Local Policies	User Rights Assignment	"Access Credential Manager as a trusted caller" to be defined but containing no entries (blank).		Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the "Access Credential Manager as a trusted caller" user right may be able to retrieve the credentials of other accounts from Credential Manager.
