package rqcode.stigs.win10_new.AuditPolicy;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;

public class AuditPolTemplate {
    private String id;
    private String guid;
    private String parameter;
    private String value;
    private String subcat_es;
    private String subcat_eng;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSubcat_es() {
        return subcat_es;
    }

    public void setSubcat_es(String subcat_es) {
        this.subcat_es = subcat_es;
    }

    public String getSubcat_eng() {
        return subcat_eng;
    }

    public void setSubcat_eng(String subcat_eng) {
        this.subcat_eng = subcat_eng;
    }
}

