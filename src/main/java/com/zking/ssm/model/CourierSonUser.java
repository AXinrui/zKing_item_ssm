package com.zking.ssm.model;


import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class CourierSonUser {
    private Integer csuid;

    private Integer cuid;

    private Integer eid;

    public CourierSonUser(Integer csuid, Integer cuid, Integer eid) {
        this.csuid = csuid;
        this.cuid = cuid;
        this.eid = eid;
    }

    public CourierSonUser() {
        super();
    }

    public Integer getCsuid() {
        return csuid;
    }

    public void setCsuid(Integer csuid) {
        this.csuid = csuid;
    }

    public Integer getCuid() {
        return cuid;
    }

    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}