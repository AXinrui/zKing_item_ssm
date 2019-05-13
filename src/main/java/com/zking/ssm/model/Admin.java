package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Component
public class Admin {
    private Integer aid;

    private String account;

    private String password;

    private String email;

    public Admin(Integer aid, String account, String password, String email) {
        this.aid = aid;
        this.account = account;
        this.password = password;
        this.email = email;
    }

    public Admin() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}