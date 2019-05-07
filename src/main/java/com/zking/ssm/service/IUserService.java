package com.zking.ssm.service;

import com.zking.ssm.model.User;
import com.zking.ssm.utils.PageBean;

import java.util.List;
import java.util.Set;

public interface IUserService {
    int doRegister(User user);//用户注册

    String doLogin(User user);//用户登陆

    int updatePassword(User user);//所有人都可以修改自己的密码

    int doResetPassword(User user);//管理员可以重置所有人的密码，密码默认值为888888

    //权限关键接口
    User loadByUsername(User user);//根据用户名查询用户
    Set<String> listPermissionsByUserName(User user);//查询指定用户拥有的权限
    Set<String> listRolesByUserName(User user);//查询指定用户拥有的角色

    List<User> userList(User user, PageBean pageBean); //查询所有

    boolean updateByPrimaryKeySelective(User record); //动态修改

    boolean updateByPrimaryKey(User record); //根据id修改全部

    boolean deleteByPrimaryKey(Integer uid);//根据id删除

    User selectByUphone(User user);//根据电话查询用户

}
