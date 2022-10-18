package rqcode.patterns.win10_new;

import rqcode.concepts.Checkable;
import rqcode.concepts.Enforceable;

import java.util.List;
import java.util.Map;

public interface STIGPattern extends Checkable, Enforceable {
    public STIGScriptPattern pattern();
    public List<Map<String, String>> checkProcess(String script) throws Exception;

}
