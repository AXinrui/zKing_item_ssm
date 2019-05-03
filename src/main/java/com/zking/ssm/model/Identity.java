package com.zking.ssm.model;


import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Identity {
    private Integer iid;

    private String iname;

    private Integer istatus;

    public Identity(Integer iid, String iname, Integer istatus) {
        this.iid = iid;
        this.iname = iname;
        this.istatus = istatus;
    }

    public Identity() {
        super();
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public Integer getIstatus() {
        return istatus;
    }

    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
    }
}