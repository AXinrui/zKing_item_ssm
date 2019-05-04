package com.zking.ssm.service.impl;

import com.zking.ssm.model.Admin;
import com.zking.ssm.service.IAdminService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AdminServiceImplTest extends BaseTestCase {

    @Autowired
    private IAdminService iAdminService;
    private Admin admin;

    @Override
    public void before() {
        super.before();
        admin = new Admin();
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void login() {
        admin.setAccount("admin");
        admin.setPassword("admin");
        boolean login = iAdminService.login(admin);
        System.out.println("login:"+login);

    }
}