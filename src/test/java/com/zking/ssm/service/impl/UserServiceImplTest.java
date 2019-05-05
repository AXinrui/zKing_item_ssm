package com.zking.ssm.service.impl;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        user.setUname("user");
        user.setUaccount("user_0000001");
        user.setUpassword("123456");
        user.setUname("真棒");
        user.setUphone("15607992781");
        user.setUaddress("河南郑州");
        user.setUstatus(1);
        user.setIid(1);

        iUserService.doRegister(user);
    }

    @Test
    public void loadByUsername() {
        user.setUaccount("liu2334693431");
        user.setUpassword("liu123654");
        String login = iUserService.doLogin(user);
        System.out.println("登录状态:" + login);
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

    @Test
    public void dolist() {
        user.setUname("dwad");
        List<User> users = iUserService.userList(user, pageBean);
        for (User user1 : users) {
            System.out.println(user1);
        }

    }
}