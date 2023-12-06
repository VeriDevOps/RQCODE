package rqcode.stigs.win10_v3.AuditPolicy;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

public abstract class AuditPolStig extends STIG {
        public static final String AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE = "auditpol /set /subcategory:\"%(guid)\" /%(parameter):%(value)";
        public static final String AUDIT_POLICY_SCRIPT_PATTERN_CHECK = "$subcat_es = \"%(subcat_es)\" \n" +
                        "$result = \"ERROR\" \n" +
                        "$subcat_eng = \"%(subcat_eng)\"\n" +
                        "$var = auditpol /get /subcategory:\"%(guid)\"\n" +
                        "$var2 = $var.ToLower()\n" +
                        "if ($var2 -like '*%(subcat_es)*' -or $var2 -like '*%(subcat_eng)*') {\n" +
                        "$result = \"OK\"\n" +
                        "}\n" +
                        "$result\n";

        private WinScriptHelper helper = new WinScriptHelper(AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE, AUDIT_POLICY_SCRIPT_PATTERN_CHECK);
        
        
        public WinScriptHelper getHelper() {
            return helper;
        }

        public void setHelper(WinScriptHelper helper) {
            this.helper = helper;
        }

        @Override
        public CheckStatus check() {
            
            setLastCheckStatus(helper.check());
    
            return getLastCheckStatus();
        }
    
        @Override
        public EnforcementStatus enforce() {   
            
            setLastEnforcementStatus(helper.enforce());
            return  getLastEnforcementStatus();
        }
    

}