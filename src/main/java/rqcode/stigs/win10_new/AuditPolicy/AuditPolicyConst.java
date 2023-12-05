package rqcode.stigs.win10_new.AuditPolicy;

public class AuditPolicyConst {
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE = "auditpol /set /subcategory:\"%(guid)\" /%(parameter):%(value)";
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_CHECK =
            "$subcat_es = \"%(subcat_es)\" \n" +
            "$result = \"ERROR\" \n" +
                    "$subcat_eng = \"%(subcat_eng)\"\n" +
                    "$var = auditpol /get /subcategory:\"%(guid)\"\n" +
                    "$var2 = $var.ToLower()\n" +
                    "if ($var2 -like '*%(subcat_es)*' -or $var2 -like '*%(subcat_eng)*') {\n" +
                    "$result = \"OK\"\n" +
                    "}\n" +
                    "$result\n" ;
}