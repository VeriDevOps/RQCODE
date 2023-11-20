package rqcode.stigs.win10_new.RegistryEdit;

import java.util.Map;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;

import rqcode.stigs.win10_new.patterns.STIGPattern;

public class RegistryEditPattern extends STIGPattern {

    private final String CHECK_PATH = "C:\\Users\\admin\\Documents\\VeriDevOps\\RQCODE\\src\\main\\java\\rqcode\\stigs\\win10_new\\RegistryEdit\\scriptsCheck\\";

    @Override
    public boolean checkProcess(String script, Map<String, String> settingValues) throws Exception {
        try (PowerShell powerShell = PowerShell.openSession()) {
            PowerShellResponse response = powerShell.executeScript(CHECK_PATH + settingValues.get("id") + ".ps1");
            String result = response.getCommandOutput();
            return result.contains("OK");
        } catch(PowerShellNotAvailableException ex) {
                return false;   
        }    
    };
}