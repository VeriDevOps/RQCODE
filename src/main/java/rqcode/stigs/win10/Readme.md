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
    
Patterns were implemented for For each Policy with corresponding name as Java abstract classes:
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
