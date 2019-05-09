package com.zking.ssm.service;

import com.zking.ssm.model.CourierSonUser;
import com.zking.ssm.utils.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICourierSonUserService {
    int deleteByPrimaryKey(Integer csuid);

    int insert(CourierSonUser record);

    int insertSelective(CourierSonUser record);

    CourierSonUser selectByPrimaryKey(Integer csuid);

    int updateByPrimaryKeySelective(CourierSonUser record);

    int updateByPrimaryKey(CourierSonUser record);

    List<CourierSonUser> listCourierSonUser(CourierSonUser courierSonUser, PageBean pageBean);

}