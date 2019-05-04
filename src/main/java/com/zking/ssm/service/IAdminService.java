package com.zking.ssm.service;

import com.zking.ssm.model.Admin;

public interface IAdminService {
    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);

    Admin getAdmin(String account);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    boolean login(Admin admin);

}
