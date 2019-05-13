package com.zking.ssm.service;

import com.zking.ssm.model.ExpressSite;

public interface IExpressSiteService {
    int deleteByPrimaryKey(Integer sid);

    int insert(ExpressSite record);

    int insertSelective(ExpressSite record);

    ExpressSite selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(ExpressSite record);

    int updateByPrimaryKey(ExpressSite record);
}