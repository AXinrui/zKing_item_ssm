package com.zking.ssm.model;

import lombok.ToString;

import java.util.Date;

@ToString
public class ExpressSite {
    private Integer sid;

    private Integer eid;

    private String x;

    private String y;

    private Integer sort;

    private Date stime;

    public ExpressSite(Integer sid, Integer eid, String x, String y, Integer sort, Date stime) {
        this.sid = sid;
        this.eid = eid;
        this.x = x;
        this.y = y;
        this.sort = sort;
        this.stime = stime;
    }

    public ExpressSite() {
        super();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }
}