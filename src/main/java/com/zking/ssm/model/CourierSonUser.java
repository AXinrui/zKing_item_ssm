package com.zking.ssm.model;


import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ToString
public class CourierSonUser implements Serializable {
    private Integer csuid;

    private Integer cuid;

    private Integer eid;

    private CourierUser courierUser;

    private Express express;

    private String csustutic;


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

    public CourierUser getCourierUser() {
        return courierUser;
    }

    public void setCourierUser(CourierUser courierUser) {
        this.courierUser = courierUser;
    }

    public Express getExpress() {
        return express;
    }

    public void setExpress(Express express) {
        this.express = express;
    }

    public String getCsustutic() {
        return csustutic;
    }

    public void setCsustutic(String csustutic) {
        this.csustutic = csustutic;
    }
}