package com.zking.ssm.mapper;

import com.zking.ssm.model.ExpressStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpressStatusMapper {
    int deleteByPrimaryKey(Integer esid);

    int insert(ExpressStatus record);

    int insertSelective(ExpressStatus record);

    ExpressStatus selectByPrimaryKey(Integer esid);

    int updateByPrimaryKeySelective(ExpressStatus record);

    int updateByPrimaryKey(ExpressStatus record);
}