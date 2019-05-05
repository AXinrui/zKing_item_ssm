package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@ToString
public class Express {
    private Integer eid;

    private String orderid;

    private String ordername;

    private Float orderprice;

    private String orderweight;

    private String ordervolume;

    private String orderaddress;

    private String orderremark;

    private Integer esid;

    private Integer uid;

    private Date shippertime;

    private String shipperphone;

    private String shipperaddress;

    private String consignee;

    private String consigneephone;

    private String consigneeaddress;

    private Date consigneetime;

    private ExpressStatus expressStatus;

    private User user;

    public Express(Integer eid, String orderid, String ordername, Float orderprice, String orderweight, String ordervolume, String orderaddress, String orderremark, Integer esid, Integer uid, Date shippertime, String shipperphone, String shipperaddress, String consignee, String consigneephone, String consigneeaddress, Date consigneetime) {
        this.eid = eid;
        this.orderid = orderid;
        this.ordername = ordername;
        this.orderprice = orderprice;
        this.orderweight = orderweight;
        this.ordervolume = ordervolume;
        this.orderaddress = orderaddress;
        this.orderremark = orderremark;
        this.esid = esid;
        this.uid = uid;
        this.shippertime = shippertime;
        this.shipperphone = shipperphone;
        this.shipperaddress = shipperaddress;
        this.consignee = consignee;
        this.consigneephone = consigneephone;
        this.consigneeaddress = consigneeaddress;
        this.consigneetime = consigneetime;
    }

    public Express() {
        super();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public Float getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Float orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrderweight() {
        return orderweight;
    }

    public void setOrderweight(String orderweight) {
        this.orderweight = orderweight;
    }

    public String getOrdervolume() {
        return ordervolume;
    }

    public void setOrdervolume(String ordervolume) {
        this.ordervolume = ordervolume;
    }

    public String getOrderaddress() {
        return orderaddress;
    }

    public void setOrderaddress(String orderaddress) {
        this.orderaddress = orderaddress;
    }

    public String getOrderremark() {
        return orderremark;
    }

    public void setOrderremark(String orderremark) {
        this.orderremark = orderremark;
    }

    public Integer getEsid() {
        return esid;
    }

    public void setEsid(Integer esid) {
        this.esid = esid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getShippertime() {
        return shippertime;
    }

    public void setShippertime(Date shippertime) {
        this.shippertime = shippertime;
    }

    public String getShipperphone() {
        return shipperphone;
    }

    public void setShipperphone(String shipperphone) {
        this.shipperphone = shipperphone;
    }

    public String getShipperaddress() {
        return shipperaddress;
    }

    public void setShipperaddress(String shipperaddress) {
        this.shipperaddress = shipperaddress;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneephone() {
        return consigneephone;
    }

    public void setConsigneephone(String consigneephone) {
        this.consigneephone = consigneephone;
    }

    public String getConsigneeaddress() {
        return consigneeaddress;
    }

    public void setConsigneeaddress(String consigneeaddress) {
        this.consigneeaddress = consigneeaddress;
    }

    public Date getConsigneetime() {
        return consigneetime;
    }

    public void setConsigneetime(Date consigneetime) {
        this.consigneetime = consigneetime;
    }

    public ExpressStatus getExpressStatus() {
        return expressStatus;
    }

    public void setExpressStatus(ExpressStatus expressStatus) {
        this.expressStatus = expressStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}