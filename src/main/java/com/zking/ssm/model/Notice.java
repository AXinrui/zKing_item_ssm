package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@ToString
public class Notice {
    private Integer nid;

    private String nname;

    private String ncontent;

    private String dictItem;

    private Date ntime;

    private Integer nstatus;

    public Notice(Integer nid, String nname, String ncontent, String dictItem, Date ntime, Integer nstatus) {
        this.nid = nid;
        this.nname = nname;
        this.ncontent = ncontent;
        this.dictItem = dictItem;
        this.ntime = ntime;
        this.nstatus = nstatus;
    }

    public Notice() {
        super();
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public String getDictItem() {
        return dictItem;
    }

    public void setDictItem(String dictItem) {
        this.dictItem = dictItem;
    }

    public Date getNtime() {
        return ntime;
    }

    public void setNtime(Date ntime) {
        this.ntime = ntime;
    }

    public Integer getNstatus() {
        return nstatus;
    }

    public void setNstatus(Integer nstatus) {
        this.nstatus = nstatus;
    }
}