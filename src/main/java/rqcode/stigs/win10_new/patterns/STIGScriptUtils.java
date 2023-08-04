package rqcode.stigs.win10_new.patterns;

import java.util.Map;

public class STIGScriptUtils {
    public static String format(String template, Map<String, String> values) {
        return values.entrySet().stream().reduce(template, (s, e) -> s.replace("%(" + e.getKey() + ")", e.getValue()),
                (s, s2) -> s);
    }
}