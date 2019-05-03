package com.zking.ssm.mapper;

import com.zking.ssm.model.Identity;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Identity record);

    int insertSelective(Identity record);

    Identity selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Identity record);

    int updateByPrimaryKey(Identity record);
}