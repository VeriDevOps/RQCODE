# **STIG Hierarchy**

STIG viewer document link: https://www.stigviewer.com/stig/windows_10/2020-06-15/

* The following diagram represents hierarchy of patterns, categories and classes:

![image](https://user-images.githubusercontent.com/5621696/177218572-420a739c-5b33-4df4-9a4f-80594324a186.png)

#STIG categories and patterns

# **Overall description of the approach**

## STIGs
Each STIG consists of the following sections:
### Overview 

![image](https://user-images.githubusercontent.com/5621696/177222197-b6b73925-72ad-498e-aae8-774cc36baeff.png)

### Details - Check Text & Fix Text 

![image](https://user-images.githubusercontent.com/5621696/177222158-47ea6780-1dd4-4b8b-ac17-f1d31b6623cd.png)

## Patterns
FAGOR document presented 5 group of policies: <br/>
    - Audit policy <br/>
    - Registry edit <br/>
    - Security policy <br/>
    - Process mitigation <br/>
    - User rights
    
Patterns were implemented for For each Policy with corresponding name as Java abstract classes: <br/>
    - AuditPolicyRequirement <br/>
    - RegistryEditRequirement <br/>
    - SecurityPolicyRequirement <br/>
    - ProcessMitigationRequirement <br/>
    - UserRightsRequirement <br/>


Each Pattern verifies the Details of the STIG. If **Check Text** inputs are correct, Pattern runs PowerShell Script.
Also, each pattern verifies **Fix Text**. It includes mutual parameters that do not change and changeable parameters with value. 

![image](https://user-images.githubusercontent.com/5621696/177222817-c67412a9-0ff3-415e-a67d-14cb4e3fafc4.png)

In the pic. _"Microsoft network client: Digitally sign communications (always)"_ is a changeable parameter and _Enabled_ is a value.

For that purpose, changeable parameter through getOption() and Value through getInclusionSetting().  


#STIG categories and patterns

**Registry Edit pattern**

This pattern covers 4 STIGs: **V-63647, V-63321, V-63703, V-63709**. 
This group of STIGs has 4 chnaging values in _CheckText_ module: Registry Path, Value name, Value Type, and Value. The pic, below is tha example of STIG # V_63647:

![image](https://user-images.githubusercontent.com/5621696/177219420-c4f13d61-6166-48e4-bbea-ca9160880dea.png)


In RegistryEditRequirement these changing values were implemented through methods:

    protected abstract String getRegistryPath();
    protected abstract String getValueName();
    protected abstract String getValueType();
    protected abstract String getValue();
    
    Conditions for PowerShell scripts are implemeted in the class:
    
    private static final String COMMAND_BODY; 
    
   In order to check the conditions of STIG we run class to request PowerShell script:
    
    Process regEditProcess = Runtime.getRuntime().exec(regEditCommand);
    
   Depending on results of _regEditProcess_, _CheckStatus check()_ method return either INCOMPLETE, PASS or FAIL.
   
  ![image](https://user-images.githubusercontent.com/5621696/177221775-5d425d50-3ec9-4db2-a2d0-e38001936e84.png)


    protected abstract String getInclusionSetting();
    
   **Security Policy Pattern**
   
   This pattern covers 4 STIGs: **V-63427, V-63423, V-63409, V-63405**. 
   
 Conditions of PowerShell scripts for these 4 STIGs V-63427 and V-63423, V-63409, V-63405 different. <br/>
 
 V-63427 PowerShell script condition:
 
![image](https://user-images.githubusercontent.com/5621696/177430616-1265c731-1c0b-402c-b9dd-53d6d98bc40a.png)

V-63423, V-63409, V-63405 PoweShell script conditions (highlighted changing value):

![image](https://user-images.githubusercontent.com/5621696/177430724-b96c2a8a-8f2a-4602-b117-6fa2d5ed322e.png)

 
 These conditions were implemented through HashMap functions. 
 
 COMMAND_TEMPLATE_MAP = new HashMap<>();
       
 And depending on conditions it returns *1* for V-63423, V-63409, V-63405 and *2* in V-63427. 
 
 ![image](https://user-images.githubusercontent.com/5621696/177431131-fb12512a-40b4-4ec2-823f-c5daeadb2195.png)

 This Funciton is callsed in classes V-63423, V-63409, V-63405:
 
    protected Integer getCommandKey() {
        return 1;
    }
   
   
   and class V-63427:
   
    protected Integer getCommandKey() {
        return 2;
    }
   
    **Process Mitigation Pattern**
   
  
   This pattern covers 4 STIGs: **V-77091, V-77095, V-77103, V-77189**. 
   
   The same function HashMap was implemented for meeting PowerShell conditions as in Security Policy Pattern
   
    **User Rights Pattern**

   This pattern covers 4 STIGs: **V-63931, V-63851, V-63863, V-63843**. 
   
   The implementation of PowerShell conditions is the same as in *Registry Edit* pattern. 

# STIG description

## Audit Policy

* **v-63447** 	<br/> Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.
 
![image](https://user-images.githubusercontent.com/5621696/177653968-17cf9ad7-431a-442e-b08a-8f7048317e38.png)


* **v-63449**	<br/> Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. User Account Management records events such as creating, changing, deleting, renaming, disabling, or enabling user accounts.
 
![image](https://user-images.githubusercontent.com/5621696/177654120-9fc68f1c-2e0f-40a9-8ca0-d09d7204e0e7.png)


* **v-63463** <br/> Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed.

![image](https://user-images.githubusercontent.com/5621696/177654375-8e2fe8fb-5951-48bc-93c9-4076ae0f6713.png)


* **v-63467** <br/>	Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed.


![image](https://user-images.githubusercontent.com/5621696/177654466-3bd2f95c-79e7-4c34-8587-4d90d25cd2c3.png)

## Registry Edit

* **v-63647** <br/>	Requests sent on the secure channel are authenticated, and sensitive information (such as passwords) is encrypted, but the channel is not integrity checked. If this policy is enabled, outgoing secure channel traffic will be signed.

![image](https://user-images.githubusercontent.com/5621696/177654659-0cdda727-50bd-491b-97da-dc103b2da493.png)

* **v-63703** <br/>	The server message block (SMB) protocol provides the basis for many network operations. Digitally signed SMB packets aid in preventing man-in-the-middle attacks. If this policy is enabled, the SMB client will only communicate with an SMB server that performs SMB packet signing.

![image](https://user-images.githubusercontent.com/5621696/177654773-ab3c5c97-34be-40b9-84b4-883a4042bd13.png)


* **v-63321** <br/>	Installation options for applications are typically controlled by administrators. This setting prevents users from changing installation options that may bypass security features.


![image](https://user-images.githubusercontent.com/5621696/177654871-d8750a1d-c7d6-44da-bb16-62f03e0047ef.png)


* **v-63709** <br/>	Passwords save locally for re-use when browsing may be subject to compromise. Disabling the Edge password manager will prevent this for the browser.

![image](https://user-images.githubusercontent.com/5621696/177654931-0c5ead93-5124-4546-9a32-1a9091eb1b37.png)

## Security Policy


* **v-63427** <br/>	The use of complex passwords increases their strength against guessing and brute-force attacks. This setting configures the system to verify that newly created passwords conform to the Windows password complexity policy.

 
![image](https://user-images.githubusercontent.com/5621696/177655221-87b7a349-12e1-4e45-a3e7-3a223e3d8529.png)

* **v-63409** <br/>	The account lockout feature, when enabled, prevents brute-force password attacks on the system. The higher this value is, the less effective the account lockout feature will be in protecting the local system. The number of bad logon attempts must be reasonably small to minimize the possibility of a successful password attack, while allowing for honest errors made during a normal user logon.

![image](https://user-images.githubusercontent.com/5621696/177655606-e66cfd31-4117-4df5-b4d1-2ddd61af1ecd.png)

* **v-63405** <br/>	The account lockout feature, when enabled, prevents brute-force password attacks on the system. This parameter specifies the amount of time that an account will remain locked after the specified number of failed logon attempts.

![image](https://user-images.githubusercontent.com/5621696/177655655-0cd7c044-abf8-4710-b25c-b563d6b5a3fc.png)

* **v-63423** <br/>	Information systems not protected with strong password schemes (including passwords of minimum length) provide the opportunity for anyone to crack the password, thus gaining access to the system and compromising the device, information, or the local network.

![image](https://user-images.githubusercontent.com/5621696/177656602-a7024f50-cabe-41f3-a09e-3f46326ece6d.png)


## 	Process mitigation

* **v-77091**	Exploit protection in Windows 10 enables mitigations against potential threats at the system and application level. Several mitigations, including "Data Execution Prevention (DEP)", are enabled by default at the system level. DEP prevents code from being run from data-only memory pages. If this is turned off, Windows 10 may be subject to various exploits. 
 
![image](https://user-images.githubusercontent.com/5621696/177655763-777bcc36-635e-42fd-bca6-156b97266538.png)

* **v-77095** <br/>	Exploit protection in Windows 10 enables mitigations against potential threats at the system and application level. Several mitigations, including "Randomize memory allocations (Bottom-Up ASLR)", are enabled by default at the system level. Bottom-Up ASLR (address space layout randomization) randomizes locations for virtual memory allocations, including those for system structures. If this is turned off, Windows 10 may be subject to various exploits.
 
![image](https://user-images.githubusercontent.com/5621696/177655820-cedcc59c-9c98-47f5-8cd2-ad276af91d79.png)


* **v-77103** <br/>	Exploit protection in Windows 10 enables mitigations against potential threats at the system and application level. Several mitigations, including "Validate heap integrity", are enabled by default at the system level. "Validate heap integrity" terminates a process when heap corruption is detected. If this is turned off, Windows 10 may be subject to various exploits.

![image](https://user-images.githubusercontent.com/5621696/177655923-2147107f-4d5e-45bb-8cbe-1785629286cc.png)

* **v-77189** <br/>	Exploit protection in Windows 10 provides a means of enabling additional mitigations against potential threats at the system and application level. Without these additional application protections, Windows 10 may be subject to various exploits.

![image](https://user-images.githubusercontent.com/5621696/177656074-5f40d7ee-2928-4cbc-809e-accf720612cf.png)

## User Rights

* **v-63863**	Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the "Create permanent shared objects" user right could expose sensitive data by creating shared objects.

![image](https://user-images.githubusercontent.com/5621696/177656189-c2140214-70f1-4745-a132-66b5f57b77fb.png)

* **v-63931**	Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the "Modify firmware environment values" user right can change hardware configuration environment variables. This could result in hardware failures or a DoS.

![image](https://user-images.githubusercontent.com/5621696/177656280-7cb595e9-5f2d-4b2a-ad5a-aaa98e5b0780.png)

* **v-63851** <br/>	Inappropriate granting of user rights can provide system, administrative, and other high-level capabilities. Accounts with the "Allow log on locally" user right can log on interactively to a system.

![image](https://user-images.githubusercontent.com/5621696/177656347-b53e27c7-d6b2-49fa-967a-6637d0177523.png)

* **v-63843** <br/>	Inappropriate granting of user rights can provide system, administrative, and other high level capabilities. Accounts with the "Access Credential Manager as a trusted caller" user right may be able to retrieve the credentials of other accounts from Credential Manager.
 
![image](https://user-images.githubusercontent.com/5621696/177656432-d097ad97-4309-4447-93a6-c68c6443842d.png)
























