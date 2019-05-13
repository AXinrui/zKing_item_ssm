package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.AdminMapper;
import com.zking.ssm.model.Admin;
import com.zking.ssm.service.IAdminService;
import com.zking.ssm.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer aid) {
        return adminMapper.deleteByPrimaryKey(aid);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer aid) {
        return adminMapper.selectByPrimaryKey(aid);
    }

    @Override
    public Admin getAdmin(String account) {
        return adminMapper.getAdmin(account);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AdminVO record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean login(Admin admin) {
        int login = adminMapper.login(admin);
        if (login>0) {
            return true;
        }else{
            return false;
        }
    }
}
