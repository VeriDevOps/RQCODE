package rqcode.stigs.win10_v3;

import rqcode.concepts.Checkable.CheckStatus;
import rqcode.concepts.Enforceable.EnforcementStatus;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Map;

/**
 * PowerShell script execution helper for Windows 10 STIGs
 */
public class WinScriptHelper {

    private final String checkScript;
    private final String enforceScript;
    private Map<String, String> checkValues;
    private Map<String, String> enforceValues;

    public WinScriptHelper(String checkScript, String enforceScript, Map<String, String> checkValues,
            Map<String, String> enforceValues) {
        this.checkScript = checkScript;
        this.enforceScript = enforceScript;
        this.checkValues = checkValues;
        this.enforceValues = enforceValues;
    }

    public WinScriptHelper(String checkScript, String enforceScript) {
        this.checkScript = checkScript;
        this.enforceScript = enforceScript;
        // this.checkValues = null;
        // this.enforceValues = null;
    }

    public EnforcementStatus enforce() {
        String script = prepareEnforceScript();

        try (PowerShell powerShell = PowerShell.openSession()) {
            System.out.println("RQCODE script :\n" + script);

            BufferedReader reader = new BufferedReader(new StringReader(script));
            PowerShellResponse response = powerShell.executeScript(reader);

            String result = response.getCommandOutput();

            System.out.println("RQCODE script execution result: " + result);
        } catch (PowerShellNotAvailableException ex) {
            ex.printStackTrace();
            return EnforcementStatus.FAILURE;
        }

        return EnforcementStatus.SUCCESS;
    }

    public CheckStatus check() {

        String script = prepareCheckScript();

        try (PowerShell powerShell = PowerShell.openSession()) {
            System.out.println("RQCODE script :\n" + script);

            BufferedReader reader = new BufferedReader(new StringReader(script));
            PowerShellResponse response = powerShell.executeScript(reader);

            String result = response.getCommandOutput();

            System.out.println("RQCODE script execution result: " + result);

            if (result.contains("OK"))
                return CheckStatus.PASS;
            else
                return CheckStatus.FAIL;
        } catch (PowerShellNotAvailableException ex) {
            ex.printStackTrace();
            return CheckStatus.INCOMPLETE;
        }
    }

    public static String format(String template, Map<String, String> values) {
        return values.entrySet().stream().reduce(template, (s, e) -> s.replace("%(" + e.getKey() + ")", e.getValue()),
                (s, s2) -> s);
    }

    public String prepareEnforceScript() {
        return format(enforceScript, enforceValues);
    }

    public String prepareCheckScript() {
        return format(checkScript, checkValues);
    }

    public Map<String, String> getCheckValues() {
        return checkValues;
    }

    public void setCheckValues(Map<String, String> checkValues) {
        this.checkValues = checkValues;
    }

    public Map<String, String> getEnforceValues() {
        return enforceValues;
    }

    public void setEnforceValues(Map<String, String> enforceValues) {
        this.enforceValues = enforceValues;
    }

}
