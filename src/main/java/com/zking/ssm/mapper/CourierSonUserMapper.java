package com.zking.ssm.mapper;

import com.zking.ssm.model.CourierSonUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierSonUserMapper {
    int deleteByPrimaryKey(Integer csuid);

    int insert(CourierSonUser record);

    int insertSelective(CourierSonUser record);

    CourierSonUser selectByPrimaryKey(Integer csuid);

    int updateByPrimaryKeySelective(CourierSonUser record);

    int updateByPrimaryKey(CourierSonUser record);
}