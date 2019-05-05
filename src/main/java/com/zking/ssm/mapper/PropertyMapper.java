package com.zking.ssm.mapper;

import com.zking.ssm.model.Property;

public interface PropertyMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Property record);

    int insertSelective(Property record);

    Property selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}