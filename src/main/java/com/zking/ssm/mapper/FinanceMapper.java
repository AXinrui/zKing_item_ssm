package com.zking.ssm.mapper;

import com.zking.ssm.model.Finance;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}