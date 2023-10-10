package rqcode.stigs.win10_new.AuditPolicy;

public class AuditPolicyConst {
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_ENFORCE = "auditpol /set /subcategory:\"%(guid)\" /%(parameter):%(value)";
    public static final String AUDIT_POLICY_SCRIPT_PATTERN_CHECK = "auditpol /get /subcategory:\"%(guid)\"

}

/*
> \"%(path)\"\n" +
            "$var1 = Get-Content \"%(path)\" | Select-String  $subcat_es,$subcat_eng\n" +
            "$var2 = $var1.Line.Replace(\" \", \"\")\n" +
            "$var2 = $var2.ToLower()\n" +

            "if ($var2 -like \"%(val_status1)\" -or $var2 -like \"%(val_status2)\") {\n" +
            "result = \"OK\"" +
            "}";
 */