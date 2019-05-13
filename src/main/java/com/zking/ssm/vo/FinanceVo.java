package com.zking.ssm.vo;

import com.zking.ssm.model.Finance;
import com.zking.ssm.utils.TransitionUtil;
import lombok.ToString;

import java.util.Date;

@ToString
public class FinanceVo extends Finance {

    private String pid;

    private String uname;

    private String ename;

    private Date dateOne;

    private Date dateTwo;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Date getDateOne() {
        return dateOne;
    }

    public void setDateOne(String dateOne) {
        this.dateOne = TransitionUtil.getDate(dateOne,1);
    }

    public Date getDateTwo() {
        return dateTwo;
    }

    public void setDateTwo(String dateTwo) {
        this.dateTwo = TransitionUtil.getDate(dateTwo,2);
    }
}
