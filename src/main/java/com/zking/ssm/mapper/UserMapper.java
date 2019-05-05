package com.zking.ssm.mapper;

import com.zking.ssm.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(String username);//根据用户名查询用户

    List<User> listUser(User user);
}