package com.zking.ssm.service;

import com.zking.ssm.model.CourierUser;
import com.zking.ssm.model.User;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.vo.CourierUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICourierUserService {
    int deleteByPrimaryKey(Integer cuid);

    int insert(CourierUser record);

    int insertSelective(CourierUser record);

    CourierUser selectByPrimaryKey(Integer cuid);

    int updateByPrimaryKeySelective(CourierUser record);

    int updateByPrimaryKey(CourierUser record);

    List<CourierUser> listCourierUser(CourierUserVo courierUserVo, PageBean pageBean);//查询全部
}