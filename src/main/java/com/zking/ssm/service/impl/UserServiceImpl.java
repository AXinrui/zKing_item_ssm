package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.UserMapper;
import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.shiro.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int doRegister(User user) {
        //md5+盐
        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(user.getUpassword(), salt);

        user.setUsalt(salt);
        user.setUpassword(credentials);
        return userMapper.insert(user);
    }

    @Override
    public User loadByUsername(User user) {
        return userMapper.selectByUsername(user.getUaccount());
    }

    @Override
    public String doLogin(User user) {
        String message = null;
        User u = userMapper.selectByUsername(user.getUaccount());
        System.out.println("登录用户：" + u);
        if (null == u || !PasswordHelper.checkCredentials(user.getUpassword(), u.getUsalt(), u.getUpassword())) {
            message = "帐号或密码错误";
        } else if (new Integer(2).equals(u.getUstatus())) {
            message = "帐号已锁定，请与管理员联系";
        } else if(null != u || PasswordHelper.checkCredentials(user.getUpassword(), u.getUsalt(), u.getUpassword())){
            message = "登录成功";
        }
        return message;
    }

    @Override
    public Set<String> listPermissionsByUserName(User user) {
        //return new HashSet<String>(userMapper.listPermissionsByUserName(user));
        return null;
    }

    @Override
    public Set<String> listRolesByUserName(User user) {
        //return new HashSet<String>(userMapper.listRolesByUserName(user));
        return null;
    }

    @Override
    public int updatePassword(User user) {
        //md5+盐
        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(user.getUpassword(), salt);


        User u = new User();
        u.setUaccount(user.getUaccount());
        u.setUpassword(credentials);
        u.setUsalt(salt);

        return userMapper.updateByPrimaryKeySelective(u);
    }

    @Override
    public int doResetPassword(User user) {
        //md5+盐
        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(User.DEFAULT_PASSWORD, salt);


        User u = new User();
        u.setUaccount(user.getUaccount());
        u.setUpassword(credentials);
        u.setUsalt(salt);

        return userMapper.updateByPrimaryKeySelective(u);
    }
}
