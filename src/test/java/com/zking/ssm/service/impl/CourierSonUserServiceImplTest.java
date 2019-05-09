package com.zking.ssm.service.impl;

import com.zking.ssm.model.CourierSonUser;
import com.zking.ssm.service.ICourierSonUserService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CourierSonUserServiceImplTest extends BaseTestCase {

    private CourierSonUser courierSonUser;
    @Autowired
    private ICourierSonUserService iCourierSonUserService;

    @Override
    public void before() {
        super.before();
        courierSonUser = new CourierSonUser();
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void listCourierSonUser() {
        pageBean.setRows(1);
        List<CourierSonUser> courierSonUsers = iCourierSonUserService.listCourierSonUser(courierSonUser, pageBean);
        for (CourierSonUser sonUser : courierSonUsers) {
            System.out.println(sonUser.toString());
            System.out.println(" sonUser.getCsuid():"+ sonUser.getCsuid());
        }


    }
}