package com.zking.ssm.mapper;

import com.zking.ssm.model.Dict;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    List<Dict> listDict(Dict dict);

    int updatedictItem(Dict dict);

    int countDict(Dict dict);
}