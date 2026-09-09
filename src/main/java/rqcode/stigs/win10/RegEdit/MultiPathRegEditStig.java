package rqcode.stigs.win10.RegEdit;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;

import rqcode.stigs.STIG;

/**
 * Base class for STIG findings whose compliance depends on the SAME
 * registry value being set at more than one location, or on more than one
 * value being set under the same key -- e.g. a policy that mirrors one
 * value across several registry paths, or a policy that requires several
 * value names under a single path to be set jointly.
 *
 * Unlike {@link RegEditStig}, which checks exactly one {path, attribute,
 * value} triple, this class composes N independent check/enforce
 * fragments -- one per triple -- and requires every fragment to report
 * "OK" for the overall check to pass (logical AND across all entries).
 * Each fragment reuses the exact same check/enforce logic as
 * {@link RegEditStig#REGISTRY_EDIT_CHECK_SCRIPT} /
 * {@link RegEditStig#REGISTRY_EDIT_ENFORCE_SCRIPT}, only with per-entry
 * variable names so the fragments do not clash when concatenated into a
 * single script.
 */
public abstract class MultiPathRegEditStig extends STIG {

    /**
     * Each entry is a {"path", "attr", "result_value"} triple, mirroring
     * RegEditStig's CHECK_VALUES/ENFORCE_VALUES map.
     */
    private List<Map<String, String>> entries;

    protected void setEntries(List<Map<String, String>> entries) {
        this.entries = entries;
    }

    protected List<Map<String, String>> getEntries() {
        return entries;
    }

    private String buildCheckScript() {
        StringBuilder sb = new StringBuilder();
        sb.append("$overallResult = \"OK\"\n");
        int i = 0;
        for (Map<String, String> entry : entries) {
            sb.append("$path").append(i).append(" = \"").append(entry.get("path")).append("\"\n");
            sb.append("$attr").append(i).append(" = \"").append(entry.get("attr")).append("\"\n");
            sb.append("$val").append(i).append(" = \"").append(entry.get("result_value")).append("\"\n");
            sb.append("$partial").append(i).append(" = \"ERROR\"\n");
            sb.append("if (Test-Path $path").append(i).append(") {\n");
            sb.append("$Key").append(i).append(" = Get-Item -LiteralPath $path").append(i).append("\n");
            sb.append("if ($Key").append(i).append(".GetValue($attr").append(i).append(", $null) -ne $null) {\n");
            sb.append("$var").append(i).append(" = Get-ItemPropertyValue -Path $path").append(i)
                    .append(" -Name $attr").append(i).append("\n");
            sb.append("if ($var").append(i).append(" -eq $val").append(i).append(") { $partial").append(i)
                    .append(" = \"OK\" }\n");
            sb.append("}\n}\n");
            sb.append("if ($partial").append(i).append(" -ne \"OK\") { $overallResult = \"ERROR\" }\n");
            i++;
        }
        sb.append("$overallResult\n");
        return sb.toString();
    }

    private String buildEnforceScript() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map<String, String> entry : entries) {
            String path = entry.get("path");
            String pathShort = path.substring(0, path.lastIndexOf('\\'));
            sb.append("$path").append(i).append(" = \"").append(path).append("\"\n");
            sb.append("$pathShort").append(i).append(" = \"").append(pathShort).append("\"\n");
            sb.append("$attr").append(i).append(" = \"").append(entry.get("attr")).append("\"\n");
            sb.append("$val").append(i).append(" = \"").append(entry.get("result_value")).append("\"\n");
            sb.append("if (!(Test-Path $pathShort").append(i).append(")) { New-Item -Path $pathShort")
                    .append(i).append(" }\n");
            sb.append("if (!(Test-Path $path").append(i).append(")) { New-Item -Path $path").append(i)
                    .append(" }\n");
            sb.append("New-ItemProperty -Force -Path $path").append(i).append(" -Name $attr").append(i)
                    .append(" -Value $val").append(i).append("\n");
            i++;
        }
        return sb.toString();
    }

    @Override
    public CheckStatus check() {
        String script = buildCheckScript();
        try (PowerShell powerShell = PowerShell.openSession()) {
            System.out.println("RQCODE script :\n" + script);
            BufferedReader reader = new BufferedReader(new StringReader(script));
            PowerShellResponse response = powerShell.executeScript(reader);
            String result = response.getCommandOutput();
            System.out.println("RQCODE script execution result: " + result);
            setLastCheckStatus(result.contains("OK") ? CheckStatus.PASS : CheckStatus.FAIL);
        } catch (PowerShellNotAvailableException ex) {
            ex.printStackTrace();
            setLastCheckStatus(CheckStatus.INCOMPLETE);
        }
        return getLastCheckStatus();
    }

    @Override
    public EnforcementStatus enforce() {
        String script = buildEnforceScript();
        try (PowerShell powerShell = PowerShell.openSession()) {
            System.out.println("RQCODE script :\n" + script);
            BufferedReader reader = new BufferedReader(new StringReader(script));
            PowerShellResponse response = powerShell.executeScript(reader);
            String result = response.getCommandOutput();
            System.out.println("RQCODE script execution result: " + result);
            setLastEnforcementStatus(EnforcementStatus.SUCCESS);
        } catch (PowerShellNotAvailableException ex) {
            ex.printStackTrace();
            setLastEnforcementStatus(EnforcementStatus.FAILURE);
        }
        return getLastEnforcementStatus();
    }

}
