package rqcode.stigs.win10_new.patterns;

import rqcode.concepts.Checkable;
import rqcode.concepts.Enforceable;
import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;
import java.util.Map;

public abstract class STIGPattern implements Checkable, Enforceable {
    public STIGScriptPattern pattern;

    public STIGPattern() {
    }

    public EnforcementStatus enforce() {
        String script = pattern.prepareEnforceScript();

        try (PowerShell powerShell = PowerShell.openSession()) {        
            PowerShellResponse response = powerShell.executeCommand(script);
            response.getCommandOutput();
        } catch(PowerShellNotAvailableException ex) {
            return EnforcementStatus.FAILURE;
        } 

        return EnforcementStatus.SUCCESS;
    }

    @Override
    public CheckStatus check() {
        Map<String, String> checkValues = pattern.getCheckValues();

        String script = pattern.prepareCheckScript();

        boolean checkResult;
        try {
            checkResult = checkProcess(script, checkValues);
        } catch (Exception e) {
            e.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }

        if (checkResult)
            return CheckStatus.PASS;
        else
            return CheckStatus.FAIL;
    }

    public boolean checkProcess(String script, Map<String, String> settingValues) throws Exception {
        try (PowerShell powerShell = PowerShell.openSession()) {        
            PowerShellResponse response = powerShell.executeCommand(script);
            String result = response.getCommandOutput();
            return result.contains("OK");
        } catch(PowerShellNotAvailableException ex) {
            return false;  
        } 
    };

    public STIGScriptPattern getPattern() {
        return pattern;
    }

    public void setPattern(STIGScriptPattern pattern) {
        this.pattern = pattern;
    }
}
