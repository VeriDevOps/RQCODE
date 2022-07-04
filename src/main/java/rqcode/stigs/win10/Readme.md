# STIG Hierarchy

* The following hierarchy of patterns, categories and classes wee implemented

![image](https://user-images.githubusercontent.com/5621696/177218572-420a739c-5b33-4df4-9a4f-80594324a186.png)

#STIG categories and patterns

**Registry Edit pattern**

This pattern covers 4 STIGs: 63647, 63321, 63703, 63709. 
This group of STIGs has 4 chnaging values in CheckText module: Registry Path, Value name, Value Type, and Value. Example of STIG # V_63647:

![image](https://user-images.githubusercontent.com/5621696/177219420-c4f13d61-6166-48e4-bbea-ca9160880dea.png)


    protected abstract String getRegistryPath();
    protected abstract String getValueName();
    protected abstract String getValueType();
    protected abstract String getValue();


# Description of  STIGs

* **v-63447**	

Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.

* **v-63449**	

Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.

* **v-63463**	

Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed

* **v-63467**	

Requests sent on the secure channel are authenticated, and sensitive information (such as passwords) is encrypted, but the channel is not integrity checked. If this policy is enabled, outgoing secure channel traffic will be signed.

* **v-63647**	

Requests sent on the secure channel are authenticated, and sensitive information (such as passwords) is encrypted, but the channel is not integrity checked. If this policy is enabled, outgoing secure channel traffic will be signed.

* **v-63703**	

The server message block (SMB) protocol provides the basis for many network operations. Digitally signed SMB packets aid in preventing man-in-the-middle attacks. If this policy is enabled, the SMB client will only communicate with an SMB server that performs SMB packet signing.

* **v-63863**	

Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the "Create permanent shared objects" user right could expose sensitive data by creating shared objects.

* **v-63931**	

Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the "Modify firmware environment values" user right can change hardware configuration environment variables. This could result in hardware failures or a DoS.

* **v-63851**	

Inappropriate granting of user rights can provide system, administrative, and other high-level capabilities. Accounts with the "Allow log on locally" user right can log on interactively to a system.

* **v-63843**

Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the "Access Credential Manager as a trusted caller" user right may be able to retrieve the credentials of other accounts from Credential Manager.
