package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

@Component
@ToString
public class User implements Serializable {

    public static final String DEFAULT_PASSWORD = "888888";

    private Integer uid;

    private String uaccount;

    private String upassword;

    private String usalt;

    private String uname;

    private String uphone;

    private String uaddress;

    private Integer ustatus;

    private Integer iid;

    private Integer pid;

    private Property property;

    private Set<CourierUser> courierUsers;
    private Set<CourierSonUser> courierSonUsers;

    public User(Integer uid, String uaccount, String upassword, String usalt, String uname, String uphone, String uaddress, Integer ustatus, Integer iid, Integer pid) {
        this.uid = uid;
        this.uaccount = uaccount;
        this.upassword = upassword;
        this.usalt = usalt;
        this.uname = uname;
        this.uphone = uphone;
        this.uaddress = uaddress;
        this.ustatus = ustatus;
        this.iid = iid;
        this.pid = pid;
    }

    public User() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUsalt() {
        return usalt;
    }

    public void setUsalt(String usalt) {
        this.usalt = usalt;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public Integer getUstatus() {
        return ustatus;
    }

    public void setUstatus(Integer ustatus) {
        this.ustatus = ustatus;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Set<CourierUser> getCourierUsers() {
        return courierUsers;
    }

    public void setCourierUsers(Set<CourierUser> courierUsers) {
        this.courierUsers = courierUsers;
    }

    public Set<CourierSonUser> getCourierSonUsers() {
        return courierSonUsers;
    }

    public void setCourierSonUsers(Set<CourierSonUser> courierSonUsers) {
        this.courierSonUsers = courierSonUsers;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}