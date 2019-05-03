package com.zking.ssm.mapper;

import com.zking.ssm.model.Notice;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer nid);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}