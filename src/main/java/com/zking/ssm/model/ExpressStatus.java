package com.zking.ssm.model;


import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ToString
public class ExpressStatus implements Serializable {
    private Integer esid;

    private String esname;

    public ExpressStatus(Integer esid, String esname) {
        this.esid = esid;
        this.esname = esname;
    }

    public ExpressStatus() {
        super();
    }

    public Integer getEsid() {
        return esid;
    }

    public void setEsid(Integer esid) {
        this.esid = esid;
    }

    public String getEsname() {
        return esname;
    }

    public void setEsname(String esname) {
        this.esname = esname;
    }
}