package com.zking.ssm.mapper;

import com.zking.ssm.model.CourierUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierUserMapper {
    int deleteByPrimaryKey(Integer cuid);

    int insert(CourierUser record);

    int insertSelective(CourierUser record);

    CourierUser selectByPrimaryKey(Integer cuid);

    int updateByPrimaryKeySelective(CourierUser record);

    int updateByPrimaryKey(CourierUser record);
}