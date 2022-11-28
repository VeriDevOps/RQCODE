package rqcode.patterns.win10_new;

import rqcode.concepts.Checkable;
import rqcode.concepts.Enforceable;

public interface STIGPattern extends Checkable, Enforceable {
    public STIGScriptPattern pattern();

    public boolean checkProcess(String script, String settingName, String settingValue) throws Exception;

}
