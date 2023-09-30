package rqcode.stigs.win10_new.AuditPolicy;

import rqcode.stigs.win10_new.patterns.STIGPattern;
import rqcode.stigs.win10_new.patterns.STIGScriptPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class AuditPolicyPattern extends STIGPattern {
    @Override
    public boolean checkProcess(String script, Map<String, String> checkValues) throws IOException {
        Process auditPol = Runtime.getRuntime().exec(script);

        BufferedReader auditPolOutputReader = new BufferedReader(new InputStreamReader(auditPol.getInputStream(), StandardCharsets.UTF_8));

        StringBuilder processOutput = new StringBuilder();
        String inputLine;

        String checkValue = checkValues.get("checkValue");

        while ((inputLine = auditPolOutputReader.readLine()) != null) {
            processOutput.append(inputLine).append(System.lineSeparator());
        }

        String result = processOutput.toString().toLowerCase();

        return result.contains("ok");
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}


