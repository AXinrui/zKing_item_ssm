package com.zking.ssm.service.impl;

import com.zking.ssm.model.Express;
import com.zking.ssm.service.IExpressService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ExpressServiceImplTest extends BaseTestCase {

    @Autowired
    private IExpressService iExpressService;

    private Express express;

    @Override
    public void before() {
        super.before();
        express = new Express();
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        express.setOrderid("123123");
        express.setOrdername("车辆");
        express.setOrderprice(50f);
        express.setOrdervolume("15");
        express.setOrderremark("20");
        express.setOrderaddress("湖南");

    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void expressList() {
        List<Express> expresses = iExpressService.expressList(express, null);
        for (Express express1 : expresses) {
            System.out.println(express1.toString());
        }

    }
}