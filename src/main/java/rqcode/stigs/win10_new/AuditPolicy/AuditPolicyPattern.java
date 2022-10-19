package rqcode.stigs.win10_new.AuditPolicy;

import rqcode.patterns.win10_new.STIGPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AuditPolicyPattern implements STIGPattern {

    @Override
    public CheckStatus check() {
        String settingName = pattern().getSettingName();
        String settingValue = pattern().getSettingValue();

        String script = pattern().prepareScript();

        List<Map<String, String>> auditPolicy;
        try {
            auditPolicy = checkProcess(script);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }

        if (auditPolicy.isEmpty())
            return CheckStatus.FAIL;

        for (Map<String, String> entry : auditPolicy) {
            if (entry.get("Subcategory").equals(settingName)
                    && entry.get("Inclusion Setting").contains(settingValue))
                return CheckStatus.PASS;
        }
        return CheckStatus.FAIL;
    }

    @Override
    public EnforcementStatus enforce() {
        String script = pattern().prepareScript();

        try {
            Process process = Runtime.getRuntime().exec(script);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return EnforcementStatus.FAILURE;
        }
        return EnforcementStatus.SUCCESS;
    }

    @Override
    public List<Map<String, String>> checkProcess(String script) throws Exception {
        Process auditPol = Runtime.getRuntime().exec(script);
        BufferedReader auditPolOutputReader = new BufferedReader(new InputStreamReader(auditPol.getInputStream()));

        List<String> rawAuditPolicy = new LinkedList<String>();
        for (String inputLine = auditPolOutputReader.readLine(); inputLine != null; inputLine = auditPolOutputReader
                .readLine()) {
            if (!inputLine.trim().isEmpty())
                rawAuditPolicy.add(inputLine);
        }
        int auditPolExitStatus = auditPol.waitFor();
        if (auditPolExitStatus != 0)
            throw new Exception(String.format("auditpol returned %d", auditPolExitStatus));

        String[] auditPolHeaders = rawAuditPolicy.get(0).split(",", -1);
        List<Map<String, String>> ret = new LinkedList<Map<String, String>>();
        for (String line : rawAuditPolicy.subList(1, rawAuditPolicy.size())) {
            String[] auditPolLineFields = line.split(",", -1);
            assert auditPolHeaders.length == auditPolLineFields.length;

            Map<String, String> auditPolEntry = new HashMap<String, String>();
            for (int i = 0; i < auditPolHeaders.length; ++i)
                auditPolEntry.put(auditPolHeaders[i], auditPolLineFields[i]);
            ret.add(auditPolEntry);
        }
        return ret;
    }
}