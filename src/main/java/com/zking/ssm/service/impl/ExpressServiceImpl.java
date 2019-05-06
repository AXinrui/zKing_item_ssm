package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.ExpressMapper;
import com.zking.ssm.model.Express;
import com.zking.ssm.service.IExpressService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExpressServiceImpl implements IExpressService {

    @Autowired
    private ExpressMapper expressMapper;


    @Override
    public boolean deleteByPrimaryKey(Integer eid) {
        return expressMapper.deleteByPrimaryKey(eid)<1?false:true;
    }

    @Override
    public boolean insert(Express record) {
        return expressMapper.insert(record)<1?false:true;
    }

    @Override
    public boolean insertSelective(Express record) {
        return expressMapper.insertSelective(record)<1?false:true;
    }

    @Override
    public Express selectByPrimaryKey(Integer eid) {
        return expressMapper.selectByPrimaryKey(eid);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Express record) {
        return expressMapper.updateByPrimaryKeySelective(record)<1?false:true;
    }

    @Override
    public boolean updateByPrimaryKey(Express record) {
        return expressMapper.updateByPrimaryKey(record)<1?false:true;
    }

    @Override
    public List<Express> expressList(Express express, PageBean pageBean) {
        return expressMapper.expressList(express);
    }
}
