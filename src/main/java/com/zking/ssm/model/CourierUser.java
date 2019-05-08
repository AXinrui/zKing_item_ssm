package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@ToString
public class CourierUser {
    private Integer cuid;

    private Integer uid;

    private String curemark;

    private Date eutime;

    private User user;

    public CourierUser(Integer cuid, Integer uid, String curemark, Date eutime) {
        this.cuid = cuid;
        this.uid = uid;
        this.curemark = curemark;
        this.eutime = eutime;
    }

    public CourierUser() {
        super();
    }

    public Integer getCuid() {
        return cuid;
    }

    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCuremark() {
        return curemark;
    }

    public void setCuremark(String curemark) {
        this.curemark = curemark;
    }

    public Date getEutime() {
        return eutime;
    }

    public void setEutime(Date eutime) {
        this.eutime = eutime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}