package com.zking.ssm.service.impl;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import com.zking.ssm.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
        user.setUaccount("user_001");
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
    }

    @Test
    public void doLogin() {
        user.setUaccount("user_001");
        user.setUpassword("123456");
        String login = iUserService.doLogin(user);
        System.out.println("登录状态:" + login);
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
        user.setUid(1);

        int userExpressSum = iUserService.getUserExpressSum(user);
        System.out.println("userExpressSum:+++"+userExpressSum);

    }

    @Test
    public void dolist() {
        List<User> users = iUserService.listUser(user, pageBean);
        List<UserVo> userVos = new ArrayList<>();
        UserVo userVo = new UserVo();
        for (User user1 : users) {
            userVo.setUser(user1);
            userVos.add(userVo);
        }
        for (UserVo user : userVos) {
            System.out.println(user.toString());
        }

    }

    @Test
    public void selectUserPhone() {
        user.setUphone("15607992781");
        User u = iUserService.selectByUphone(user);
        System.out.println(u);
    }


}