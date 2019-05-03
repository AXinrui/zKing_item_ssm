package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@ToString
public class Finance {
    private Integer fid;

    private Integer uid;

    private Integer eid;

    private Date ftime;

    private String fremark;

    public Finance(Integer fid, Integer uid, Integer eid, Date ftime, String fremark) {
        this.fid = fid;
        this.uid = uid;
        this.eid = eid;
        this.ftime = ftime;
        this.fremark = fremark;
    }

    public Finance() {
        super();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date ftime) {
        this.ftime = ftime;
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark;
    }
}