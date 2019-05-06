package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Property {
    private Integer pid;

    private Float pbalance;

    private String ppwd;

    private Integer pstatus;

    public Property(Integer pid, Float pbalance, String ppwd, Integer pstatus) {
        this.pid = pid;
        this.pbalance = pbalance;
        this.ppwd = ppwd;
        this.pstatus = pstatus;
    }

    public Property() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Float getPbalance() {
        return pbalance;
    }

    public void setPbalance(Float pbalance) {
        this.pbalance = pbalance;
    }

    public String getPpwd() {
        return ppwd;
    }

    public void setPpwd(String ppwd) {
        this.ppwd = ppwd;
    }

    public Integer getPstatus() {
        return pstatus;
    }

    public void setPstatus(Integer pstatus) {
        this.pstatus = pstatus;
    }
}