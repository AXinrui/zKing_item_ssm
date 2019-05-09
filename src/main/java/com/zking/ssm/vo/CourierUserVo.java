package com.zking.ssm.vo;

import com.zking.ssm.model.CourierUser;
import com.zking.ssm.model.Express;
import com.zking.ssm.utils.TransitionUtil;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;


@ToString
@Component
public class CourierUserVo extends CourierUser{

    private Date dateOne;
    private Date dateTwo;

    private String  string1;

    private String string2;

    public CourierUserVo() {
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

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }
}
