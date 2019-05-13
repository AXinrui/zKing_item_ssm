package com.zking.ssm.vo;

import com.zking.ssm.model.Admin;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
public class AdminVO extends Admin {

    private String ypwd;

    public AdminVO() {
    }

    public String getYpwd() {
        return ypwd;
    }

    public void setYpwd(String ypwd) {
        this.ypwd = ypwd;
    }
}
