package com.zking.ssm.mapper;

import com.zking.ssm.model.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}