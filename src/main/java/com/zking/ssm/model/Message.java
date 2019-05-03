package com.zking.ssm.model;


import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Message {
    private Integer mid;

    private String mname;

    private String mphone;

    private String mcontent;

    private Integer mstatus;

    public Message(Integer mid, String mname, String mphone, String mcontent, Integer mstatus) {
        this.mid = mid;
        this.mname = mname;
        this.mphone = mphone;
        this.mcontent = mcontent;
        this.mstatus = mstatus;
    }

    public Message() {
        super();
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public Integer getMstatus() {
        return mstatus;
    }

    public void setMstatus(Integer mstatus) {
        this.mstatus = mstatus;
    }
}