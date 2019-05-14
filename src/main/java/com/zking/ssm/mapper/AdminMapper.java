package com.zking.ssm.mapper;

import com.zking.ssm.model.Admin;
import com.zking.ssm.vo.AdminVO;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(AdminVO record);

    int login(Admin admin);

    Admin getAdmin(String account);

    Admin loadAdmin(String email);
}