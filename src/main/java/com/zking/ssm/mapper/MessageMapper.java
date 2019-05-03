package com.zking.ssm.mapper;

import com.zking.ssm.model.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}