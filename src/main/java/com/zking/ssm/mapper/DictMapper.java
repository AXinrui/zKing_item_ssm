package com.zking.ssm.mapper;

import com.zking.ssm.model.Dict;

import java.util.List;

public interface DictMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    List<Dict> listDict(Dict dict);
}