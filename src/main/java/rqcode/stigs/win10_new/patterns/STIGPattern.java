package rqcode.stigs.win10_new.patterns;

import rqcode.concepts.Checkable;
import rqcode.concepts.Enforceable;

public interface STIGPattern extends Checkable, Enforceable {
    public STIGScriptPattern pattern();

    public boolean checkProcess(String script, String settingName, String settingValue, String settingType) throws Exception;

}
