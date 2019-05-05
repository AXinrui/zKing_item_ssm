package com.zking.ssm.service;

import com.zking.ssm.model.Dict;

public interface IDictService {

    int deleteByPrimaryKey(Integer tid);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

}
