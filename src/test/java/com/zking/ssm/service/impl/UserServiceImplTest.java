package com.zking.ssm.service.impl;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends BaseTestCase {

    @Autowired
    private IUserService iUserService;
    private User user;

    @Override
    public void before() {
        super.before();
        user = new User();
    }

    @Test
    public void doRegister() {
        user.setUname("admin");
        user.setUaccount("liu2334693431");
        user.setUpassword("liu123654");
        user.setUname("离子");
        user.setUphone("13407992540");
        user.setUaddress("湖南长沙");
        user.setUstatus(1);
        user.setIid(1);

        iUserService.doRegister(user);
    }

    @Test
    public void loadByUsername() {
    }

    @Test
    public void doLogin() {


    }

    @Test
    public void listPermissionsByUserName() {
    }

    @Test
    public void listRolesByUserName() {
    }

    @Test
    public void updatePassword() {
    }

    @Test
    public void doResetPassword() {
    }
}