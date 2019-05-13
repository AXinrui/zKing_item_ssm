package com.zking.ssm.mapper;

import com.zking.ssm.model.ExpressSite;

public interface ExpressSiteMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(ExpressSite record);

    int insertSelective(ExpressSite record);

    ExpressSite selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(ExpressSite record);

    int updateByPrimaryKey(ExpressSite record);
}