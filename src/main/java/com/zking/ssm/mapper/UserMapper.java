package com.zking.ssm.mapper;

import com.zking.ssm.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(String username);//根据用户名查询用户

    List<User> listUser(User user);

    int getUserExpressSum(User user);//得到快递员的订单数量

    User selectByUphone(User user);//根据电话查询用户

}