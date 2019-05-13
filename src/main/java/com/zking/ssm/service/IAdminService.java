package com.zking.ssm.service;

import com.zking.ssm.model.Admin;
import com.zking.ssm.vo.AdminVO;

public interface IAdminService {
    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);

    Admin getAdmin(String account);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(AdminVO record);

    boolean login(Admin admin);

}
