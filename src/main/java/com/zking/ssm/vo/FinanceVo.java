package com.zking.ssm.vo;

import com.zking.ssm.model.Finance;
import lombok.ToString;

@ToString
public class FinanceVo extends Finance {

    private String pid;

    private String uname;

    private String ename;

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
}
