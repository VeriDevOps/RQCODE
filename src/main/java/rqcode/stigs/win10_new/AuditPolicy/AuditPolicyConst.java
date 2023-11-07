package rqcode.stigs.win10_new.AuditPolicy;

public class AuditPolicyConst {
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE = "auditpol /set /subcategory:\"%(guid)\" /%(parameter):%(value)";
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_CHECK =
            "$subcat_es = %(subcat_es)\n" +
            "$subcat_en = %(subcat_en)\n" +
            "auditpol /get /subcategory:\"%(guid)\" > c:\\Audit.Policy.cfg\n" +
            "$var1 = Get-Content C:\\Audit.Policy.cfg" +
            "$var2 = $var1 -join \" \"" +
            "$var2 = $var2.ToLower()" +

            "if ($var2 -like $subcat_es -or $var2 -like $subcat_eng)" +
            "$result = \"OK\"" +
            "}\n" +
            "Write-Host \"Result: $result\"" ;

}


//
