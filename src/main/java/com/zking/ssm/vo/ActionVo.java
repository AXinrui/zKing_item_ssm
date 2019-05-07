package com.zking.ssm.vo;

import com.zking.ssm.model.Express;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;


@ToString
@Component
public class ActionVo{

    private Date dateOne;
    private Date dateTwo;

    private int esid;

    private String orderid;

    public ActionVo() {
    }

    public Date getDateOne() {
        return dateOne;
    }

    public void setDateOne(Date dateOne) {
        this.dateOne = dateOne;
    }

    public Date getDateTwo() {
        return dateTwo;
    }

    public void setDateTwo(Date dateTwo) {
        this.dateTwo = dateTwo;
    }

    public int getEsid() {
        return esid;
    }

    public void setEsid(int esid) {
        this.esid = esid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
