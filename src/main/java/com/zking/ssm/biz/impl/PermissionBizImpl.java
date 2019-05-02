package com.zking.ssm.biz.impl;

import com.zking.ssm.biz.IPermissionBiz;
import com.zking.ssm.mapper.PermissionMapper;
import com.zking.ssm.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionBizImpl implements IPermissionBiz {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int add(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int del(Permission permission) {
        return permissionMapper.deleteByPrimaryKey(permission.getPermissionId());
    }
}
