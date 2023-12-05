package rqcode.stigs.win10_v3;

import java.util.Map;

import rqcode.stigs.STIG;

public abstract class WinStig extends STIG {

    private Map<String, String> stigInfo;

    public WinStig(Map<String, String> stigInfo){
        this.stigInfo=stigInfo;
    }

    @Override
    public String id() {
        return stigInfo.get("id");
    }

    @Override
    public String version() {
        return stigInfo.get("version");
    }

    @Override
    public String ruleID() {
        return stigInfo.get("ruleID");
    }

    @Override
    public String iacontrols() {
        return stigInfo.get("iacontrols");
    }

    @Override
    public String severity() {
        return stigInfo.get("severity");
    }

    @Override
    public String description() {
        return stigInfo.get("description");
    }

    @Override
    public String title() {
        return stigInfo.get("title()");
    }

    @Override
    public String date() {
        return stigInfo.get("date");
    }

    @Override
    public String checkid() {
        return stigInfo.get("checkid");
    }

    @Override
    public String checktext() {
        return stigInfo.get("checktext");
    }

    @Override
    public String fixid() {
        return stigInfo.get("fixid");
    }

    @Override
    public String fixtext() {
        return stigInfo.get("fixtext");
    }
    
}
